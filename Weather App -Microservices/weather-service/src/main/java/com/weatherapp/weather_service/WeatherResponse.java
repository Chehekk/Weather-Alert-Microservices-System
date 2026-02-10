package com.weatherapp.weather_service;

public class WeatherResponse {
    private String cityName;
    private String description;
    private double temperature;

    public WeatherResponse(String cityName, String description, double temperature) {
        this.cityName = cityName;
        this.description = description;
        this.temperature = temperature;
    }

    // Getters
    public String getCityName() { return cityName; }
    public String getDescription() { return description; }
    public double getTemperature() { return temperature; }
}

