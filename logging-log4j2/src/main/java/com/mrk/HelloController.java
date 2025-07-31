package com.mrk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Java 17 compatible Spring Boot controller with Log4j2 logging
 * Demonstrates modern Java features and optimized logging patterns
 */
@Controller
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);

    // Using Java 17 List.of() for immutable list (more efficient than Arrays.asList)
    private static final List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5);

    @GetMapping("/")
    public String main(Model model) {
        
        // Java 17 pattern matching and text blocks for better readability
        var timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        
        // Modern structured logging with Java 17 features
        logger.info("Processing request for main page at: {}", timestamp);
        
        // Java 17 enhanced lambda logging with structured data
        logger.debug("Application data - numbers: {}, size: {}", 
                    () -> NUMBERS, 
                    () -> NUMBERS.size());

        // Using Java 17 switch expressions (if needed for conditional logic)
        var messageType = switch (NUMBERS.size()) {
            case 0 -> "empty";
            case 1 -> "single";
            case 2, 3, 4, 5 -> "multiple";
            default -> "many";
        };
        
        logger.debug("Data classification: {}", messageType);

        // Add attributes to model using modern syntax
        model.addAttribute("tasks", NUMBERS);
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("dataType", messageType);

        return "welcome"; // view
    }

    /**
     * Example method demonstrating Java 17 record usage for structured logging
     */
    private record LogEntry(String level, String message, LocalDateTime timestamp) {
        public LogEntry(String level, String message) {
            this(level, message, LocalDateTime.now());
        }
    }

    private void logWithStructure(String message) {
        var entry = new LogEntry("INFO", message);
        logger.info("Structured log entry: {}", entry);
    }

}
