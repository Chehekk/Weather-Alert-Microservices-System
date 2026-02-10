package com.weather.user_service;

public class WeatherDTO {
    private String cityName;
    private String description;
    private double temperature;

    public String getCityName() { return  cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
}
