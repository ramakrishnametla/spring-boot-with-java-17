# Spring Boot 3.x Examples and Tutorials

A comprehensive collection of Spring Boot 3.x examples and tutorials demonstrating modern Java development practices with Java 17.

## Overview

This repository contains multiple Spring Boot projects showcasing different features and integrations. Each project is self-contained and demonstrates specific Spring Boot capabilities with modern Java 17 features.

## Key Features:
- **Spring Boot 3.1.2** with Jakarta EE
- **Java 17** with modern language features  
- **Spring Security 6.x** configurations
- **JUnit 5** testing framework
- **Spring Data JPA** with various databases
- **RESTful web services** with validation
- **Thymeleaf templating** and WebFlux reactive programming
- **Docker** containerization examples
- **Externalized configuration** patterns
- **Logging** with SLF4J/Logback and Log4j2

## Requirements:
- Java 17 or higher
- Maven 3.6+
- Docker (for containerized examples)

## Project Structure

### Core Spring Boot Examples
- **spring-boot-hello-world** - Basic Spring Boot web application
- **spring-boot-change-port** - Server port configuration examples
- **spring-boot-commandlinerunner** - Command line runner implementations
- **spring-boot-autoconfiguration** - Auto-configuration examples

### Data Access
- **spring-data-jpa** - Basic JPA repository examples
- **spring-data-jpa-mysql** - MySQL database integration
- **spring-data-jpa-postgresql** - PostgreSQL database integration
- **spring-data-jpa-paging-sorting** - Pagination and sorting examples
- **spring-data-jpa-test** - JPA testing strategies
- **spring-jdbc** - JDBC template examples with stored procedures

### Web Development
- **spring-rest-hello-world** - RESTful web services basics
- **spring-rest-validation** - REST API validation examples
- **spring-rest-error-handling** - Global exception handling
- **spring-rest-security** - Secured REST endpoints
- **web-thymeleaf** - Thymeleaf template engine
- **web-thymeleaf-war** - WAR deployment example
- **webflux-thymeleaf** - Reactive web programming
- **webflux-thymeleaf-serversentevent** - Server-sent events

### Configuration & Properties
- **profile-simple** - Spring profiles with Java configuration
- **profile-properties** - Properties-based profiles
- **profile-yaml** - YAML configuration examples
- **spring-boot-externalize-config** - External configuration sources
- **spring-boot-externalize-config-2** - Environment-specific configs
- **spring-boot-externalize-config-3** - Custom property sources
- **spring-boot-externalize-config-4** - Test configuration overrides
- **yaml-simple** - YAML configuration parsing

### Testing
- **testing-junit5-mockito** - JUnit 5 and Mockito integration
- **spring-boot-test-json** - JSON testing with @JsonTest
- **spring-boot-testcontainers** - Integration testing with Testcontainers

### Advanced Features
- **spring-boot-docker** - Docker containerization
- **spring-boot-ssl** - HTTPS/SSL configuration
- **spring-boot-jobrunr** - Background job processing
- **email** - Email integration examples

### Logging
- **logging-log4j2** - Log4j2 configuration and usage
- **spring-boot-logging-slf4j-logback** - SLF4J with Logback

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/ramakrishnametla/spring-boot-with-java-17.git
   cd spring-boot-with-java-17
   ```

2. Navigate to any project directory:
   ```bash
   cd spring-boot-hello-world
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Running Individual Projects

Each project can be run independently. Most web applications will start on port 8080 unless configured otherwise.

### Example: Hello World
```bash
cd spring-boot-hello-world
mvn clean compile
mvn spring-boot:run
```
Access at: http://localhost:8080

### Example: JPA with H2
```bash
cd spring-data-jpa
mvn spring-boot:run
```
H2 Console: http://localhost:8080/h2-console

## Testing

Run tests for any project:
```bash
mvn test
```

For integration tests with Testcontainers:
```bash
cd spring-boot-testcontainers
mvn test
```

## Docker Examples

Build and run Docker containers:
```bash
cd spring-boot-docker
mvn clean package
docker build -t spring-boot-with-java-17-app .
docker run -p 8080:8080 spring-boot-with-java-17-app
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Reference](https://spring.io/projects/spring-data-jpa)
- [Spring Security Documentation](https://spring.io/projects/spring-security)
- [Java 17 Features](https://openjdk.java.net/projects/jdk/17/)
