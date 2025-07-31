## What is it?
This source code is a Spring Boot web application (MVC + Thymeleaf) with Docker support.
 
Tested with
* Docker 19.03+
* Java 17
* Spring Boot 3.1.2
* Maven
* Thymeleaf

This project demonstrates how to containerize a Spring Boot application using Docker.

## How to run this?
```bash
$ git clone https://github.com/ramakrishnametla/spring-boot-with-java-17.git
$ cd spring-boot-with-java-17/spring-boot-docker
$ mvn clean package
$ java -jar target/spring-boot-web.jar

  access http://localhost:8080

//dockerize

// create a docker image
$ sudo docker build -t spring-boot:1.0 .
// run it
$ sudo docker run -d -p 8080:8080 -t spring-boot:1.0

  access http://localhost:8080
```