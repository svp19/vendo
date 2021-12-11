import os
import random
import hashlib
import logging
import cloudinary
import cloudinary.uploader
from dotenv import load_dotenv
from flask import Flask, request, redirect, render_template, Response, jsonify
from flask_cors import CORS, cross_origin
from flask_sqlalchemy import SQLAlchemy
from base64 import urlsafe_b64encode as b64e, urlsafe_b64decode as b64d
from make_captcha import image_captcha

# Load Environment Variables
load_dotenv()

# Setup Flask App
app = Flask(__name__)
CORS(app)
app.logger.setLevel(logging.INFO)
app.config['SQLALCHEMY_DATABASE_URI'] = os.getenv('SQLALCHEMY_DATABASE_URI')
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

# DB
db = SQLAlchemy(app)

class AdCampaign(db.Model):
    __tablename__ = 'ad_campaigns'
    id = db.Column(db.Integer, primary_key=True)
    poster_address = db.Column(db.String(64))
    max_token_budget = db.Column(db.Integer)
    image_url = db.Column(db.String(2048))
    redirect_url = db.Column(db.String(2048))
    tag_lines = db.Column(db.String(320))
    created_at = db.Column(db.DateTime, server_default=db.func.now())
    updated_at = db.Column(db.DateTime, server_default=db.func.now(), server_onupdate=db.func.now())

    def __init__(self, poster_address, max_token_budget, image_url, redirect_url, tag_lines):
        self.poster_address = poster_address
        self.max_token_budget = max_token_budget
        self.image_url = image_url
        self.redirect_url = redirect_url
        self.tag_lines = tag_lines
    
    def serialize(self):
        return {
            # 'poster_address': self.poster_address,
            # 'max_token_budget': self.max_token_budget,
            # 'created_at': self.created_at,
            'image_url': self.image_url,
            # 'redirect_url': self.redirect_url,
            'ad_url': os.getenv('SERVER_URL') + 'click?ad_campaign=' + b64e(str(self.id).encode()).decode(),
            'tag_lines': self.tag_lines
        }


class Integrator(db.Model):
    __tablename__ = 'ad_integrators'
    id = db.Column(db.Integer, primary_key=True)
    integrator_address = db.Column(db.String(64))
    integrator_hash = db.Column(db.String(256))

    def __init__(self, integrator_address,):
        self.integrator_address = integrator_address
        self.integrator_hash = hashlib.sha256(integrator_address.encode()).hexdigest()


class Click(db.Model):
    __tablename__ = 'ad_clicks'
    id = db.Column(db.Integer, primary_key=True)
    viewer_address = db.Column(db.String(64))
    ad_campaign_id = db.Column(db.Integer, db.ForeignKey('ad_campaigns.id'))
    created_at = db.Column(db.DateTime, server_default=db.func.now())

    def __init__(self, viewer_address, ad_campaign_id):
        self.viewer_address = viewer_address
        self.ad_campaign_id = ad_campaign_id


class Captcha(db.Model):
    __tablename__ = 'ad_captchas'
    public_id = db.Column(db.String(256), primary_key=True)
    passphrase = db.Column(db.String(32))

    def __init__(self, public_id, passphrase):
        self.public_id = public_id
        self.passphrase = passphrase
    

# Routes
@app.route('/')
@cross_origin()
def index():
    return render_template('index.html')

@app.route('/api/health_status/', methods=['GET', 'POST'])
def health_check():
    return Response("{'status': 'success', 'description': 'App is running'}", status=200, mimetype='application/json')

@app.route('/signup', methods=['POST'])
@cross_origin()
def submit():
    if request.method == 'POST':
        integrator_address = request.form['integrator_address']
        # TODO: validate if address valid
        if db.session.query(Integrator).filter(Integrator.integrator_address == integrator_address).count() == 0:
            data = Integrator(integrator_address)
            db.session.add(data)
            db.session.commit()
            app.logger.info(data.id)
            return render_template('success.html', integrator=data)
        return render_template('index.html', message='You have already signed up')

@app.route('/api/serve/', methods=['GET'])
@cross_origin()
def serve_ad():    
    app.logger.info('serving_ad')
    ad = AdCampaign.query.order_by(AdCampaign.created_at.desc()).first()
    if ad is None:
        return
    ad = ad.serialize()
    tag_line = random.choice(ad["tag_lines"].split('|')) 
    img_captcha = image_captcha.generate(tag_line)
    folder = os.getenv('CLOUD_FOLDER') + '/captchas'
    result = cloudinary.uploader.upload(img_captcha, folder=folder)
    app.logger.info(result)
    ad['captcha_url'] = result['url']
    ad['public_id'] = result['public_id']
    data = Captcha(result['public_id'], tag_line)
    db.session.add(data)
    db.session.commit()
    app.logger.info('committed_to_db__%s', data.public_id)
    ad.pop('tag_lines', None)
    return jsonify(ad)

@app.route('/api/verify/', methods=['GET'])
def verify_captcha():    
    app.logger.info('verifying_captcha')
    public_id = request.args.get('public_id')
    passphrase = request.args.get('passphrase')
    captcha = db.session.query(Captcha).filter(Captcha.public_id == public_id).first()
    # TODO token transfer
    if captcha and passphrase == captcha.passphrase:
        return jsonify({'verified': 'true'})
    return jsonify({'verified': 'false'})


@app.route('/api/upload/', methods=['POST']) 
@cross_origin()
def upload_ad_campaign():
    app.logger.info('uploading_ad_campaign')
    # Upload image to Cloudinary
    cloudinary.config(cloud_name = os.getenv('CLOUD_NAME'),
                    api_key=os.getenv('API_KEY'), 
                    api_secret=os.getenv('API_SECRET'))
    result = None
    if request.method == 'POST':
        file_to_upload = request.files['file']
        app.logger.info('file_to_upload__%s', file_to_upload)
        if file_to_upload:
            result = cloudinary.uploader.upload(file_to_upload, folder=os.getenv('CLOUD_FOLDER'))
            app.logger.info(result)
        # Store AdCampaign campaign details to DB
        if result is not None and 'url' in result.keys():
            data = AdCampaign(request.form['poster_address'], request.form['max_token_budget'],
                              result['url'], request.form['redirect_url'], request.form['tag_lines'])
            db.session.add(data)
            db.session.commit()
            app.logger.info('committed_to_db__%s', data.id)
    return jsonify(result)


@app.route('/click/', methods=['GET'])
@cross_origin()
def url_redirect():
    ad_campaign_id = b64d(request.args.get('ad_campaign')).decode()
    integrator_hash = request.args.get('integrator_hash')
    viewer_address = request.args.get('viewer_address')
    ad = AdCampaign.query.get(ad_campaign_id)
    integrator = db.session.query(Integrator).filter(Integrator.integrator_hash == integrator_hash).first()
    if ad and integrator and viewer_address:
        # Store Click to DB
        data = Click(viewer_address, ad_campaign_id)
        db.session.add(data)
        db.session.commit()
        app.logger.info(data.id)
        # If already clicked no tokens!
        if db.session.query(Click).filter(Click.viewer_address == viewer_address, Click.ad_campaign_id == ad_campaign_id).count() == 1:
            # TODO - Transfer tokens via smart contract, if diff pricing then impressions
            app.logger.info('transfer[integrator]_%s_to_%s', ad.poster_address, integrator.integrator_address)
            app.logger.info('transfer[viewer]_%s_to_%s', ad.poster_address, viewer_address)
            # return jsonify(ad.redirect_url)
        return redirect(ad.redirect_url)
    return jsonify({})

# if __name__ == '__main__':
#     db.create_all()
#     status = db.session.commit()
#     # app.run(host='0.0.0.0', port=3001, debug=True)


db.create_all()
status = db.session.commit()