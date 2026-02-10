package com.weatherapp.weather_service;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class weatherController {
    private final String apiKey = "7dbf5b979535b6effbf48e3be36d3a09";

    @GetMapping("/weather/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        String name = (String) response.get("name");

        Map<String, Object> main = (Map<String, Object>) response.get("main");
        double temp = (double) main.get("temp");

        java.util.List<Map<String, Object>> weatherList = (java.util.List<Map<String, Object>>) response.get("weather");
        String desc = (String) weatherList.get(0).get("description");


        String result = restTemplate.getForObject(url, String.class);

       return new WeatherResponse(name, desc, temp);
    }
}


