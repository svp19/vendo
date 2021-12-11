var arrayABI = [{"inputs":[],"stateMutability":"payable","type":"constructor"},{"inputs":[{"internalType":"bytes32","name":"impressionId","type":"bytes32"}],"name":"impressionAlreadyViewed","type":"error"},{"anonymous":false,"inputs":[{"indexed":true,"internalType":"address","name":"owner","type":"address"},{"indexed":true,"internalType":"address","name":"spender","type":"address"},{"indexed":false,"internalType":"uint256","name":"value","type":"uint256"}],"name":"Approval","type":"event"},{"anonymous":false,"inputs":[{"indexed":true,"internalType":"address","name":"from","type":"address"},{"indexed":true,"internalType":"address","name":"to","type":"address"},{"indexed":false,"internalType":"uint256","name":"value","type":"uint256"}],"name":"Transfer","type":"event"},{"inputs":[{"internalType":"address","name":"owner","type":"address"},{"internalType":"address","name":"spender","type":"address"}],"name":"allowance","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"spender","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"approve","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"address","name":"account","type":"address"}],"name":"balanceOf","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[],"name":"decimals","outputs":[{"internalType":"uint8","name":"","type":"uint8"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"spender","type":"address"},{"internalType":"uint256","name":"subtractedValue","type":"uint256"}],"name":"decreaseAllowance","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"bytes32","name":"","type":"bytes32"}],"name":"impressionIds","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"spender","type":"address"},{"internalType":"uint256","name":"addedValue","type":"uint256"}],"name":"increaseAllowance","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[],"name":"mint","outputs":[],"stateMutability":"payable","type":"function"},{"inputs":[],"name":"name","outputs":[{"internalType":"string","name":"","type":"string"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"string","name":"adId","type":"string"},{"internalType":"bytes32","name":"hashMessage","type":"bytes32"},{"internalType":"uint8","name":"v","type":"uint8"},{"internalType":"bytes32","name":"r","type":"bytes32"},{"internalType":"bytes32","name":"s","type":"bytes32"},{"internalType":"address","name":"integrator","type":"address"}],"name":"onClick","outputs":[],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"string","name":"adId","type":"string"}],"name":"postAd","outputs":[],"stateMutability":"payable","type":"function"},{"inputs":[{"internalType":"string","name":"","type":"string"}],"name":"postings","outputs":[{"internalType":"address","name":"","type":"address"}],"stateMutability":"view","type":"function"},{"inputs":[],"name":"symbol","outputs":[{"internalType":"string","name":"","type":"string"}],"stateMutability":"view","type":"function"},{"inputs":[],"name":"totalSupply","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"recipient","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"transfer","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"address","name":"sender","type":"address"},{"internalType":"address","name":"recipient","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"transferFrom","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[],"name":"vendo","outputs":[{"internalType":"address","name":"","type":"address"}],"stateMutability":"view","type":"function"}]
var mainContractAddress = "0x646bf517bc3504Fb0a6BC128C8EcbcA54E8cDC67";
var web3 = new Web3(Web3.givenProvider || "http://127.0.0.1:7545");

async function verifyCaptcha() {
    var passphrase = document.querySelector("#adspace-captcha-form [name='passphrase']").value;
    var publicId = document.querySelector("#adspace-captcha-form-public-id").value;
    const response = await fetch(`http://localhost:3001/api/verify/?public_id=${publicId}&passphrase=${passphrase}`, {
        method: 'GET',  
        headers: {'Content-Type': 'application/json'}
    })
    responseJSON = await response.json();
    if (responseJSON['verified'] === 'true'){ // If captcha verified
        console.log('In Here')
        console.log(web3)
        console.log('Above')
        if (typeof web3 !== 'undefined'){
            console.log('InHere')
            web3.eth.getAccounts(function(err, accounts){
                myAccountAddress = accounts[3];
                var myContract = new web3.eth.Contract(arrayABI, mainContractAddress, {
                    from: myAccountAddress,
                });
                var randomNounce = 1;
                var adId="MQ==";
                var integrator_address = "0xd7F20f15aA2E39bDB21c4B80845462B7E842F7c7";
                // call smart contract
                console.log("This one JSON", responseJSON);
                
                console.log(
                    adId, 
                    responseJSON["messageHash"],
                    responseJSON["v"],
                    responseJSON["r"],
                    responseJSON["s"],
                    integrator_address);
                 
                myContract.methods.onClick(
                    adId, 
                    responseJSON["messageHash"],
                    responseJSON["v"],
                    responseJSON["r"],
                    responseJSON["s"],
                    integrator_address,
                ).send({from: myAccountAddress, gas: 1000000}).then(
                    x => console.log(x)
                );
                console.log("Called onClick");
                // console.log(myAccountAddress);
                // console.log(myContract);
                
            })
        }
        document.getElementById("adspace").innerHTML += "<br>Tokens credited!</br>";
    } else {
        document.getElementById("adspace").innerHTML += "<br>Invalid captcha entered.</br>";
    }
    console.log(w());
}

async function loadAd() {
    const response = await fetch('http://localhost:3001/api/serve/', {
        method: 'GET',
        headers: {
        'Content-Type': 'application/json'
        }
    });
    const adJSON = await response.json(); //extract JSON from the http response
    var intHash = document.getElementById('adspace').getAttribute('data-integrator-hash');
    var viewer_address = "TODO"
    var adHTML = `AD<br><a href="${adJSON.ad_url}&integrator_hash=${intHash}&viewer_address=${viewer_address}"><img src="${adJSON.image_url}"></a>`;
    document.getElementById("adspace").innerHTML = adHTML;
    var captchaHTML = `<center>
                            <br>
                            <h4>Claim Free AdTokens!</h4>
                            <form id="adspace-captcha-form">
                                <div class="form-group">
                                    <img src="${adJSON.captcha_url}">
                                    <br>
                                <input type="text" name="passphrase" placeholder="Enter text"/>
                                <input type="hidden" id="adspace-captcha-form-public-id" value="${adJSON.public_id}">
                                <input id="adspace-captcha-form-btn" type="button" value="Verify" class="btn" onclick="verifyCaptcha()"/>
                                </div>
                        </center>`
    document.getElementById("adspace").innerHTML += captchaHTML;
}

document.addEventListener('DOMContentLoaded', function() {
    loadAd();
}, false);

