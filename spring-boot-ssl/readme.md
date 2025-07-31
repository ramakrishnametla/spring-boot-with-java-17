## What is it?
This source code is a Spring Boot SSL (HTTPS) example.

Tested with
* Maven 3
* Java 17
* Spring Boot 3.1.2
* Spring Boot default embedded Tomcat 10
* Self-signed certificate (PKCS12)

This project demonstrates how to enable SSL/HTTPS in Spring Boot using self-signed certificates.

## How to run this?
```bash
$ git clone https://github.com/ramakrishnametla/spring-boot-with-java-17.git

$ cd spring-boot-with-java-17/spring-boot-ssl

$ mvn clean package

$ java -jar target/spring-boot-web.jar

  access https://localhost:8443
```