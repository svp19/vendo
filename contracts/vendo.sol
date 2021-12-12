// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;


import "@openzeppelin/contracts/token/ERC20/ERC20.sol";

contract Token is ERC20 {
  address public vendo;    
  mapping(string => address) public postings;
  mapping(bytes32 => bool) public impressionIds;

  // Constructor to initialize the address of the deployer
  constructor() payable ERC20("vendo", "ven") {
    vendo = msg.sender;
  }

  // Errors
  error impressionAlreadyViewed(bytes32 impressionId);
  error failedToRedeem(address redeemer);
  error insuffucuantFundsSent(uint256 amount);

  // Function to post an ad
  function postAd(string memory adId) external payable {
    // Accept Polygon and mint tokens
    // For every polygon, generate 30000 tokens
    uint tokens = msg.value * 3333 / (1 ether);
    if (tokens == 0) {
      revert insuffucuantFundsSent(msg.value);
    }
  
    // Mint token into the add posters address
		_mint(msg.sender, tokens);

    // Add advertisement
    postings[adId] = msg.sender;
  }

  function redeem(uint256 tokens) external payable {
    // Transfer tokens to vendo wallet
    transfer(vendo, tokens);

    // Transfer polygons to the redeemer
    uint amount = tokens * (1 ether) / 3333;
    if (!payable(msg.sender).send(amount)) {
      revert failedToRedeem(msg.sender);
    }
  }

  function onClick(string memory adId, bytes32 hashMessage, uint8 v,
    bytes32 r, bytes32 s, address integrator) external {
    // Check if impressionid already in list of impression Ids
    if (impressionIds[hashMessage] == true) {
      revert impressionAlreadyViewed(hashMessage);
    }

    // Decrypt message and assert decrypted message to
    assert(vendo == ecrecover(hashMessage, v, r, s));

    // Update impressionId map to true
    impressionIds[hashMessage] = true;

    address adPoster = postings[adId];

    // Transfer tokens to integrator, viewer and the smartContract deployer
    _transfer(adPoster, integrator, 7);
    _transfer(adPoster, msg.sender, 1);
    _transfer(adPoster, vendo, 2);
  }
}
