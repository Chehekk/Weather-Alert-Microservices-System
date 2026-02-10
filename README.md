# Weather-Alert-Microservices-System
This project is a Java Spring Boot–based microservices application that simulates a real-world weather alert system. The application is designed using a distributed architecture where independent services communicate with each other using REST APIs.

Architecture Overview:
The system consists of three microservices:

1. Weather Service:
Responsible for fetching real-time weather data from the OpenWeatherMap API. It processes and converts external API responses into clean Java objects.
Port: 8081

2. User Service:
Manages users and their weather alert preferences using an H2 database. It acts as the central service that coordinates with other services. When requested, it fetches user details, retrieves weather data for the user’s city, and determines whether a notification should be triggered.
Port: 8080

3. Notification Service:
Handles alert delivery. It listens for instructions from the User Service and simulates sending notifications by printing alert messages to the console.
Port: 8082

Inter-Service Communication:
All services communicate over HTTP using REST APIs. The User Service interacts with the Weather and Notification services using RestTemplate. URL encoding is handled to ensure safe and reliable communication between services.

Technologies Used:
- Java 17
- Spring Boot
- Maven
- REST APIs
- JPA (Hibernate)
- H2 Database
- JSON Parsing

Key Learnings:
- Designing and implementing microservices architecture
- Handling inter-service communication using REST
- Managing databases with JPA
- Debugging real-world issues such as port conflicts and compilation errors
- Integrating third-party APIs into backend systems
