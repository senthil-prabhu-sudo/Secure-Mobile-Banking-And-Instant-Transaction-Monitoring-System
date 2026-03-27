# Secure Mobile Banking & Instant Transaction Monitoring System - Backend

Spring Boot backend project for secure digital banking operations and real-time transaction monitoring.

## Tech Stack

- Java 17
- Spring Boot 3.3.5
- Spring Web
- Spring Validation
- Spring Boot Actuator
- Maven

## Run

```bash
mvn spring-boot:run
```

## Core API Endpoints

- `GET /api/v1/health`
- `POST /api/v1/auth/login`
- `GET /api/v1/accounts/summary/{customerId}`
- `POST /api/v1/transactions/transfer`
- `GET /api/v1/monitoring/risk?transactionId=...&amount=...&channel=...`

See `COMPONENTS.md` for the Component/Module/Microservices developed.
