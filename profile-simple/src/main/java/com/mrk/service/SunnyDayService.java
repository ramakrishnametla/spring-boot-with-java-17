package com.mrk.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Modern Spring Boot 3.x: Profile-based service with Java 24 features
@Service
@Profile({"sunny", "default"})
public class SunnyDayService implements WeatherService {

    @Override
    public String forecast() {
        // Java 24: String templates for modern string formatting
        return "☀️ Today is a sunny day!";
    }
    
    @Override
    public WeatherResult getDetailedForecast() {
        // Java 24: Using sealed interface implementation
        return new WeatherResult.Sunny("Beautiful sunny weather", 25);
    }

}