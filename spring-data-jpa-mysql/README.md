# Spring Boot + Spring Data JPA + MySQL example

This project demonstrates Spring Boot integration with Spring Data JPA and MySQL database, including Testcontainers for integration testing.


## Technologies used:
* Spring Boot 3.1.2
* Spring Data JPA (Hibernate 6 is the default JPA implementation)
* MySQL 8
* Java 17
* Maven 3
* JUnit 5
* Spring Test using TestRestTemplate
* Docker, [Testcontainers](https://testcontainers.com/) (for Spring integration tests using a MySQL container)

## How to run it
```

$ git clone https://github.com/ramakrishnametla/spring-boot-with-java-17.git

$ cd spring-boot-with-java-17/spring-data-jpa-mysql

# Run MySQL container for testing
$ docker run --name c1 -p 3306:3306 -e MYSQL_USER=mkyong -e MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=mydb -d mysql:8.1

# Skip test, the Testcontainers takes time
$ ./mvnw clean package -Dmaven.test.skip=true

$ ./mvnw spring-boot:run

```


