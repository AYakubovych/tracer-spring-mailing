# tracer-spring-mailin

Mailing service of Tracer project.

Deployed on: http://ayakubovych.ddns.net

>First load lasts about 20-30 seconds due to the remoteness of the dns server for ddns.net

###Description

This service serves requests from all parts Tracer project, 
after generates and sends mails  
* [tracer-react-frontend](https://github.com/AYakubovych/tracer-react-frontend)
* [tracer-spring-backend](https://github.com/AYakubovych/tracer-spring-backend)
* [tracer-android-service](https://github.com/AYakubovych/tracer-android-service)

###Deployment

To run this you must have Maven and Java installed and smtp account.
Then you have to change data in application.properties
```properties
spring.mail.host=smtp.gmail.com
spring.mail.username=xxx
spring.mail.password=xxx
spring.mail.port=587
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
After, use this commands to run this app. 

```shell script
    mvn clean install
    java -jar tracer-0.1.1-SNAPSHOT.jar
```

