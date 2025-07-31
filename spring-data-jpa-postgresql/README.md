# Spring Boot + Spring Data JPA + PostgreSQL example

This project demonstrates Spring Boot integration with Spring Data JPA and PostgreSQL database, including Testcontainers for integration testing.


## Technologies used:
* Spring Boot 3.1.2
* Spring Data JPA (Hibernate 6  is the default JPA implementation)
* PostgreSQL 15
* Maven
* Java 17
* JUnit 5
* Docker
* [REST Assured](https://rest-assured.io/) and [Testcontainers](https://testcontainers.com/) (for Spring integration tests using a container)

## How to run it
```

$ git clone https://github.com/ramakrishnametla/spring-boot-with-java-17.git

$ cd spring-boot-with-java-17/spring-data-jpa-postgresql

$ ./mvnw clean package -Dmaven.test.skip=true

$ docker run --name pg1 -p 5432:5432 -e POSTGRES_USER=mkyong -e POSTGRES_PASSWORD=password -e POSTGRES_DB=mydb -d postgres:15-alpine

$ ./mvnw spring-boot:run

```