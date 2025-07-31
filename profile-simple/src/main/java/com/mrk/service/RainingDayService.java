package com.mrk.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Modern Spring Boot 3.x service with Java 24 enhancements
@Service
@Profile("raining")
public class RainingDayService implements WeatherService {

    @Override
    public String forecast() {
        // Java 24: Modern string formatting with emojis
        return "🌧️ Today is a rainy day!";
    }
    
    @Override
    public WeatherResult getDetailedForecast() {
        // Java 24: Using sealed interface implementation
        return new WeatherResult.Rainy("Expect rain throughout the day", 85);
    }

}
