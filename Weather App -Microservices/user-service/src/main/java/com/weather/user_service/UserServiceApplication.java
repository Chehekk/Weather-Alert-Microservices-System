package com.weather.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(UserRepository repository) {
		return args -> {
			repository.save(new User("Alice", "New York", 20.0));  // alice wants a warning if its below 0°C
			repository.save(new User("John Doe", "Mumbai"));
		};
	}
}



