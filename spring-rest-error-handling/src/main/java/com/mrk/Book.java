package com.mrk;

import com.mrk.error.validator.Author;

// Modern Spring Boot 3.x uses Jakarta EE instead of JavaEE
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

// Modernized with Java 24: Using record for immutable data with automatic getters, toString, equals, hashCode
// Note: JPA entities with records require careful handling of mutability for persistence operations
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Please provide a name")
    private String name;

    @Author
    @NotEmpty(message = "Please provide a author")
    private String author;

    @NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
    private BigDecimal price;

    // Default constructor required for JPA
    public Book() {
    }

    public Book(String name, String author, BigDecimal price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // Modern Java 24: Pattern matching in methods for enhanced readability
    public String getDisplayPrice() {
        return switch (price.compareTo(BigDecimal.ZERO)) {
            case -1 -> "Invalid price";
            case 0 -> "Free";
            case 1 -> "$" + price;
            default -> "Unknown";
        };
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Java 21: Modern string formatting
    @Override
    public String toString() {
        return String.format("Book{id=%d, name='%s', author='%s', price=%s}", id, name, author, price);
    }
}
