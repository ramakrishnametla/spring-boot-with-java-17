package com.mrk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * Spring Boot 3.x application with Java 17 features and Log4j2 logging
 * Demonstrates modern Spring Boot patterns and structured logging
 */
@SpringBootApplication
public class StartApplication {

    private static final Logger logger = LogManager.getLogger(StartApplication.class);

    public static void main(String[] args) {
        // Log application startup with Java version info
        logger.info("Starting Spring Boot application with Java {} on {}", 
                   System.getProperty("java.version"),
                   System.getProperty("os.name"));
        
        // Configure system properties for optimal Java 17 performance
        System.setProperty("java.awt.headless", "true");
        System.setProperty("log4j2.asyncLoggerWaitStrategy", "Block");
        
        var context = SpringApplication.run(StartApplication.class, args);
        
        logger.info("Application started successfully with {} active profiles", 
                   (Object[]) context.getEnvironment().getActiveProfiles());
    }

    /**
     * Java 17 compatible event listener for application ready state
     */
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        // Java 17 text block for multi-line log message
        var welcomeMessage = """
                ==============================================
                🚀 Spring Boot Log4j2 Application Ready! 
                📋 Java Version: %s
                🔧 Log4j2 Configuration: Active
                🌐 Server: http://localhost:8080
                ==============================================
                """.formatted(System.getProperty("java.version"));
        
        logger.info(welcomeMessage);
        
        // Demonstrate structured logging with Java 17 records
        logSystemInfo();
    }

    private void logSystemInfo() {
        record SystemInfo(String javaVersion, String springBootVersion, 
                         long maxMemory, int availableProcessors) {}
        
        var systemInfo = new SystemInfo(
            System.getProperty("java.version"),
            SpringApplication.class.getPackage().getImplementationVersion(),
            Runtime.getRuntime().maxMemory() / 1024 / 1024, // MB
            Runtime.getRuntime().availableProcessors()
        );
        
        logger.info("System Information: {}", systemInfo);
    }

}
