# Ad Server in Flask

1. `/upload/` - POST method to upload advertisment
    - Images uploaded to Cloudinary
    - Ad Campaign details uploaded to DB (SQL)

2. `/serve/` - GET method that returns advertisment in JSON
    - queries DB and returns ad JSON based on critera


## Security Protocol

1. `GET: /serve`

2. `GET: /click?ad_campaign=abcd&integrator_hash=0x1234&viewer_address=0x5678`
- Register Click
    - ip address
    - viewer_address
    - ad_id
    - created_at
    - tokens_transferred
- Cooldown period for clicking, Limit expected token rewards in long run and serve Captchas to prevent fake clicks and accordingly blacklist.

## Quick Gists

`ALTER USER postgres PASSWORD '123456';`

## Deploying to Heroku

`heroku create decentads`

`heroku addons:create heroku-postgresql:hobby-dev --app decentads`

Created postgresql-amorphous-80651 as DATABASE_URL

`heroku config --app decentads`

`git push heroku master`

`heroku logs --tail`

#### Example Wallet Address
`0xABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890YAYS`
