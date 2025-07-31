package com.mrk.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Modern Java 21 Record for Book Data Transfer Object
 * Records provide immutable data carriers with automatic implementations of:
 * - Constructor
 * - Getters (accessor methods)
 * - equals() and hashCode()
 * - toString()
 */
public record BookDTO(
    @NotEmpty(message = "Please provide a name")
    String name,
    
    @NotEmpty(message = "Please provide an author")
    String author,
    
    @NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
    BigDecimal price
) {
    
    // Java 21: Record can have additional methods and validation
    public BookDTO {
        // Compact constructor for validation (Java 14+, enhanced in Java 21)
        if (name != null) {
            name = name.trim();
        }
        if (author != null) {
            author = author.trim();
        }
    }
    
    // Java 21: Pattern matching in record methods
    public String getDisplayPrice() {
        return switch (price.compareTo(BigDecimal.ZERO)) {
            case -1 -> "Invalid price";
            case 0 -> "Free";
            case 1 -> "$" + price;
            default -> "Unknown";
        };
    }
    
    // Java 21: Record method with pattern matching
    public boolean isExpensive() {
        return price.compareTo(new BigDecimal("100")) > 0;
    }
    
    // Java 21: Modern string formatting
    public String getBookSummary() {
        return String.format("%s by %s - %s", name, author, getDisplayPrice());
    }
}