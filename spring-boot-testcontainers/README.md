# Spring Boot and Testcontainers Example

This project demonstrates how to use Testcontainers for integration testing with Spring Boot and PostgreSQL.

## Technologies:
* Spring Boot 3.1.2 (Spring Web MVC, Spring Data JPA and Spring Test)
* Testcontainers 1.19.0
* PostgreSQL 15, Alpine Linux base image `postgres:15-alpine`
* Java 17
* JUnit 5

## How to start
```
$ git clone https://github.com/ramakrishnametla/spring-boot-with-java-17.git

$ cd spring-boot-with-java-17/spring-boot-testcontainers

$ ./mvnw test

$ ./mvnw spring-boot:run
```