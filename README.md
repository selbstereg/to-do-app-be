# Local setup

Set the VM option `-Dspring.profiles.active="dev"` to use application-dev.properties

# Deployment

Simply enter 
```
git push heroku master
```
The push to the remote heroku will trigger a deployment. View the result with 
```$xslt
heroku logs --tail
```

# Links
article on how to deploy to heroku
https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku

repo on
https://git.heroku.com/obscure-hollows-92479.git

deployment on heroku
https://obscure-hollows-92479.herokuapp.com/
