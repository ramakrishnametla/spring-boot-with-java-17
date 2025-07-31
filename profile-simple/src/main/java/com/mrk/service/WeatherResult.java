package com.mrk.service;

/**
 * Java 17: Sealed interface with pattern matching for weather results
 * Sealed interfaces restrict which classes can implement them, providing better type safety
 */
public sealed interface WeatherResult
    permits WeatherResult.Sunny, WeatherResult.Rainy, WeatherResult.Unknown {
    
    record Sunny(String message, int temperature) implements WeatherResult {
        public Sunny {
            // Compact constructor validation
            if (temperature < -50 || temperature > 60) {
                throw new IllegalArgumentException("Invalid temperature range");
            }
        }
        
        // Java 17: Modern string formatting
        public String getDisplayMessage() {
            return String.format("%s Temperature: %d°C", message, temperature);
        }
    }
    
    record Rainy(String message, int humidity) implements WeatherResult {
        public Rainy {
            // Validation in compact constructor
            if (humidity < 0 || humidity > 100) {
                throw new IllegalArgumentException("Humidity must be between 0-100%");
            }
        }
        
        public String getDisplayMessage() {
            return String.format("%s Humidity: %d%%", message, humidity);
        }
    }
    
    record Unknown(String reason) implements WeatherResult {
        public String getDisplayMessage() {
            return String.format("Weather unknown: %s", reason);
        }
    }
    
    // Java 17: Traditional instanceof checking with sealed types
    default String getFormattedForecast() {
        if (this instanceof Sunny sunny) {
            return String.format("☀️ %s (%d°C)", sunny.message(), sunny.temperature());
        } else if (this instanceof Rainy rainy) {
            return String.format("🌧️ %s (%d%% humidity)", rainy.message(), rainy.humidity());
        } else if (this instanceof Unknown unknown) {
            return String.format("❓ %s", unknown.reason());
        }
        return "Unknown weather";
    }
}