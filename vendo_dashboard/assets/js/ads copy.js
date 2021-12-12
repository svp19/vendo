var arrayABI = [{"inputs":[],"stateMutability":"payable","type":"constructor"},{"inputs":[{"internalType":"bytes32","name":"impressionId","type":"bytes32"}],"name":"impressionAlreadyViewed","type":"error"},{"anonymous":false,"inputs":[{"indexed":true,"internalType":"address","name":"owner","type":"address"},{"indexed":true,"internalType":"address","name":"spender","type":"address"},{"indexed":false,"internalType":"uint256","name":"value","type":"uint256"}],"name":"Approval","type":"event"},{"anonymous":false,"inputs":[{"indexed":true,"internalType":"address","name":"from","type":"address"},{"indexed":true,"internalType":"address","name":"to","type":"address"},{"indexed":false,"internalType":"uint256","name":"value","type":"uint256"}],"name":"Transfer","type":"event"},{"inputs":[{"internalType":"address","name":"owner","type":"address"},{"internalType":"address","name":"spender","type":"address"}],"name":"allowance","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"spender","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"approve","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"address","name":"account","type":"address"}],"name":"balanceOf","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[],"name":"decimals","outputs":[{"internalType":"uint8","name":"","type":"uint8"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"spender","type":"address"},{"internalType":"uint256","name":"subtractedValue","type":"uint256"}],"name":"decreaseAllowance","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"bytes32","name":"","type":"bytes32"}],"name":"impressionIds","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"spender","type":"address"},{"internalType":"uint256","name":"addedValue","type":"uint256"}],"name":"increaseAllowance","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[],"name":"mint","outputs":[],"stateMutability":"payable","type":"function"},{"inputs":[],"name":"name","outputs":[{"internalType":"string","name":"","type":"string"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"string","name":"adId","type":"string"},{"internalType":"bytes32","name":"hashMessage","type":"bytes32"},{"internalType":"uint8","name":"v","type":"uint8"},{"internalType":"bytes32","name":"r","type":"bytes32"},{"internalType":"bytes32","name":"s","type":"bytes32"},{"internalType":"address","name":"integrator","type":"address"}],"name":"onClick","outputs":[],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"string","name":"adId","type":"string"}],"name":"postAd","outputs":[],"stateMutability":"payable","type":"function"},{"inputs":[{"internalType":"string","name":"","type":"string"}],"name":"postings","outputs":[{"internalType":"address","name":"","type":"address"}],"stateMutability":"view","type":"function"},{"inputs":[],"name":"symbol","outputs":[{"internalType":"string","name":"","type":"string"}],"stateMutability":"view","type":"function"},{"inputs":[],"name":"totalSupply","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"recipient","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"transfer","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"address","name":"sender","type":"address"},{"internalType":"address","name":"recipient","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"transferFrom","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[],"name":"vendo","outputs":[{"internalType":"address","name":"","type":"address"}],"stateMutability":"view","type":"function"}]
// var mainContractAddress = "0x646bf517bc3504Fb0a6BC128C8EcbcA54E8cDC67";
var mainContractAddress = "0xACeEc683060Dc4eAF6e052eE9cF0FDf0a9b6B10C";
var web3 = new Web3(Web3.givenProvider || "http://127.0.0.1:7545");





async function getBalance() {
    if (typeof web3 !== 'undefined'){
        web3.eth.getAccounts(async function(err, accounts){
            myAccountAddress = accounts[3];
            let balancePOLY = await web3.eth.getBalance(myAccountAddress);
            balancePOLY = web3.utils.fromWei(balancePOLY);
            balancePOLY = Math.round(balancePOLY * 100) / 100.0
            document.getElementById('polygon-count').innerHTML = `${balancePOLY} ETH`
            console.log('#Balance', balancePOLY)
        })
    }
}

async function getTransactionsCount() {
    if (typeof web3 !== 'undefined'){
        web3.eth.getAccounts(async function(err, accounts){
            myAccountAddress = accounts[3];
            let transactionsCount = await web3.eth.getTransactionCount(myAccountAddress);
            document.getElementById('impression-count').innerHTML = transactionsCount
            console.log("#Impressions", transactionsCount);
        })
    }
}

async function getBalanceTokens() {
    if (typeof web3 !== 'undefined'){
        web3.eth.getAccounts(async function(err, accounts){
            myAccountAddress = accounts[3];
            var myContract = new web3.eth.Contract(arrayABI, mainContractAddress, {
                from: myAccountAddress,
            });
            let balanceTokens = await myContract.methods.balanceOf(myAccountAddress).call();
            document.getElementById('token-count').innerHTML = `${balanceTokens} VND`
            console.log('#Tokens', balanceTokens)
        })
    }
}


document.addEventListener('DOMContentLoaded', function() {

    getBalance();
    getTransactionsCount();
    getBalanceTokens();

    setInterval(function(){
        getBalance();
        getTransactionsCount();
        getBalanceTokens();
    }, 1000);
}, false);






// class TransactionChecker {
//     constructor(address) {
//         this.address = address.toLowerCase();
//         this.web3 = new Web3(Web3.givenProvider || "http://127.0.0.1:7545");
// }

// async checkBlock() {
//     console.log("Function called checkblock")
//     let block = await this.web3.eth.getBlock('latest');
//     let number = block.number;
//     let transactions = block.transactions;
//     //console.log('Search Block: ' + transactions);

//     if (block != null && block.transactions != null) {
//         for (let txHash of block.transactions) {
//             let tx = await this.web3.eth.getTransactionReceipt(txHash);
//             // if (this.address == tx.to.toLowerCase() || true) {
//             //     console.log("from: " + tx.from.toLowerCase() + " to: " + tx.to.toLowerCase() + " value: " + tx.value);
//             // }
//             console.log("from: " + tx.from.toLowerCase() + " to: " + tx.to.toLowerCase() + " value: " + tx.value);
//             console.log(tx)

//         }
//     }
//   }
// }

//  var transactionChecker = new  TransactionChecker('0x22dCCf05349Ccde1f5C98428516e455B8d4613e2');
//  transactionChecker.checkBlock();
