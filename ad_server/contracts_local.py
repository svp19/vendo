import json
import web3
from web3 import Web3
from eth_account.messages import encode_defunct

w3 = Web3(Web3.HTTPProvider('http://127.0.0.1:7545'))

# print(w3.eth.get_block('latest'))

# message = 'some-text-tö-sign'
# private_key = bytes('0xd3CdA913deB6f67967B99D67aCDFa1712C293601', 'utf-8')
# signed_message = w3.eth.account.sign_message(message, private_key=private_key)
# print(signed_message)

msg = "some-text-tö-sign"
pk = "6b1e0f4d03c792dc07c45ed3af1990403ed59874b965943d92acbd44e5c936ac"
private_key = pk
message = encode_defunct(text=msg)
print(message)
print()
signed_message = w3.eth.account.sign_message(message, private_key=private_key)
print(signed_message.messageHash, signed_message.r, signed_message.s, signed_message.v, signed_message.signature)

# with open("../abis/vendo.json", "r") as f:
#     abi = f.read()

# contract_addr="0x646bf517bc3504Fb0a6BC128C8EcbcA54E8cDC67"
# contract = w3.eth.contract(address=contract_addr, abi=abi) 
# postAd = contract.functions.postAd().call()
# txn = contract.functions.feed("1").buildTransaction({
#     'chainId': 13999911119,
#     'gas': 70000,
#     'value': 1,
#     'gasPrice': w3.toWei('8', 'gwei'),
#     'nonce': 1
# })
# signed_txn = w3.eth.account.sign_transaction(txn, private_key=private_key)
# w3.eth.sendRawTransaction(signed_txn.rawTransaction)

# # postAd = contract.functions.postAd("1000").transact()
# # print(postAd)



# contract.functions.

# bal = contract.functions.balanceOf("0xf7f0d9e35873873b2136B0c0CBC9718561e12591").call()
# print(bal)