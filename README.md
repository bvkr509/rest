# Rest Application

This repository contains a **Spring Boot REST application** developed with hands‑on implementation of **core and advanced Spring Boot concepts**.  
The project focuses on **clean architecture, security, validation, exception handling, and production readiness**.


## Technologies Used

- Java
- Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA
- Spring Security
- JWT Authorization
- OAuth2 Authorization (Preparation)
- Spring Boot Actuator
- Maven
- Swagger / OpenAPI
- Git & GitHub

---

## Spring Boot Concepts Implemented

The following **Spring Boot concepts have been fully implemented** in this application.

---

### Core Spring Boot Concepts
- **Spring Boot Architecture**  
  Implemented layered architecture using Controller, Service, and Repository layers.

- **Dependency Injection (DI)**  
  Used constructor‑based dependency injection to achieve loose coupling and better testability.

**Bean Lifecycle**  
  Understood and applied Spring bean creation and lifecycle management handled by the Spring container.

- **Spring Boot Configuration**  
  Externalized configuration using `application.properties` and environment‑based setup.

---

### 🌐 REST API Fundamentals
- **REST Fundamentals**  
  Implemented stateless RESTful APIs using standard HTTP methods.

- **Controller Layer**  
  Built REST controllers using `@RestController`.

- **Request Mapping**  
  Used `@GetMapping`, `@PostMapping`, `@PutMapping`, and `@DeleteMapping` for endpoint routing.

- **DTOs (Data Transfer Objects)**  
  Used DTOs to separate API contracts from persistence entities.

- **Validation**  
  Implemented request validation using Jakarta Validation annotations such as:
  - `@NotNull`
  - `@NotBlank`
  - `@Min`

---

### 🚨 Exception Handling
- **Global Exception Handling**  
  Centralized API exception handling for consistent error responses.

- **@ControllerAdvice**  
  Used `@ControllerAdvice` to handle exceptions across all controllers.

- **Custom Error Responses**  
  Returned meaningful, structured error responses to clients.

---

### 🗄️ Persistence Layer
- **Spring Data JPA**  
  Integrated Spring Data JPA for database access.

- **Entity Mapping**  
  Created JPA entities and mapped them to database tables.

- **Repository Layer**  
  Used JPA repositories to perform CRUD operations.

---

### 🔐 Security Implementation
- **Spring Security**  
  Secured REST APIs using Spring Security filter chain.

- **JWT Authorization**  
  Implemented token‑based authentication using JWT:
  - Token generation
  - Token validation
  - `Authorization: Bearer <token>` header

- **OAuth 2.0 Authorization (Preparation)**  
  Understood OAuth2 authorization concepts and prepared the application for OAuth2 / Keycloak based integration.

- **Role‑Based Access Control**  
  Implemented role‑based authorization using roles such as `USER` and `ADMIN`.

---

### 🩺 Monitoring & Observability
- **Spring Boot Actuator**  
  Enabled Actuator for production‑ready monitoring.

- **Health Endpoints**
  - `/actuator/health`
  - `/actuator/health/liveness`
  - `/actuator/health/readiness`
