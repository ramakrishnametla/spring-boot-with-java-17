package com.mrk.service;

/**
 * Modern Weather Service interface with Java 24 features
 */
public interface WeatherService {

    String forecast();
    
    // Java 24: Default method with modern features
    default WeatherResult getDetailedForecast() {
        // Default implementation returns unknown weather
        return new WeatherResult.Unknown("Default forecast not available");
    }

}