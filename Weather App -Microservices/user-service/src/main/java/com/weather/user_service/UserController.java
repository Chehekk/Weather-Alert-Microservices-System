package com.weather.user_service;

import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 1. Create a user
    @PostMapping
    public User createUser(@RequestParam String name, @RequestParam String city, @RequestParam double threshold) {
        return userRepository.save(new User(name, city, threshold));
    }

    // 2. Get User + Weather
    @GetMapping("/{id}/weather")
    public String getUserWeather(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        RestTemplate restTemplate = new RestTemplate();
        // Calling Weather Service on 8081
        WeatherDTO weather = restTemplate.getForObject("http://localhost:8081/weather/" + user.getCity(), WeatherDTO.class);

        String res = "User " + user.getName() + " in " + user.getCity() + " has weather: " 
                    + weather.getDescription() + " at " + weather.getTemperature() + "°C";

        // Logic for Notification
        if (weather.getTemperature() < user.getColdThreshold()) {
            String message = "Warning! It is freezing in " + user.getCity();
            
            // Fixed the URL encoding for @ and spaces
            String notifyUrl = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/notify/alert")
                    .queryParam("email", "alice@example.com")
                    .queryParam("message", message)
                    .build()
                    .toUriString();

            try {
                // Calling Notification Service on 8082
                restTemplate.postForObject(notifyUrl, null, String.class);
                res += " [ALERT SENT!]";
            } catch (Exception e) {
                res += " [Alert failed: " + e.getMessage() + "]";
            }
        } 

        return res;
    } // Closes getUserWeather
}