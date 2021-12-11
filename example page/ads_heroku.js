async function verifyCaptcha() {
    var passphrase = document.querySelector("#adspace-captcha-form [name='passphrase']").value;
    var publicId = document.querySelector("#adspace-captcha-form-public-id").value;
    const response = await fetch(`http://decentads.herokuapp.com/api/verify/?public_id=${publicId}&passphrase=${passphrase}`, {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    })
    responseJSON = await response.json();
    if (responseJSON['verified'] === 'true'){
        document.getElementById("adspace").innerHTML += "<br>Tokens credited!</br>";
    } else {
        document.getElementById("adspace").innerHTML += "<br>Invalid captcha entered.</br>";
    }
}

async function loadAd() {
    const response = await fetch('http://decentads.herokuapp.com/api/serve/', {
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