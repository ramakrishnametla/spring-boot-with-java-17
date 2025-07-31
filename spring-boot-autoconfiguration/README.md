# Spring Boot @ConditionalOnProperty example

This project demonstrates how to use @ConditionalOnProperty annotation to conditionally enable Spring Boot auto-configuration based on application properties.

## Technologies used:
* Spring Boot 3.1.2
* Java 17
* Maven


## How to run it
```

$ git clone https://github.com/ramakrishnametla/spring-boot-with-java-17.git

$ cd spring-boot-with-java-17/spring-boot-autoconfiguration

$ ./mvnw spring-boot:run

$ ./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dapp.feature.new=true"

```