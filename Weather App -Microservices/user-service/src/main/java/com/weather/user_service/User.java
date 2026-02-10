package com.weather.user_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // creates a table in DB called 'users'
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    public User() {}
    public User(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCity() { return city; }

    private double coldThreshold;
    public User(String name, String city, double coldThreshold) {
        this.name = name;
        this.city = city;
        this.coldThreshold = coldThreshold;
    }

    // getter
    public double getColdThreshold() { return coldThreshold; }
}
