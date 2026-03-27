# Component / Module / Microservices Developed

## 1) Identity & Access Module

- Purpose: Handles secure login, token issuance flow placeholders, and role-based identity context.
- Package: `com.bank.secure.backend.auth`
- Exposed APIs:
  - `POST /api/v1/auth/login`

## 2) Account Management Module

- Purpose: Provides account summary and customer balance view.
- Package: `com.bank.secure.backend.account`
- Exposed APIs:
  - `GET /api/v1/accounts/summary/{customerId}`

## 3) Payments & Transfer Module

- Purpose: Handles transfer requests and transaction lifecycle status.
- Package: `com.bank.secure.backend.transaction`
- Exposed APIs:
  - `POST /api/v1/transactions/transfer`

## 4) Instant Transaction Monitoring Module

- Purpose: Performs real-time risk scoring and identifies transactions requiring manual review.
- Package: `com.bank.secure.backend.monitoring`
- Exposed APIs:
  - `GET /api/v1/monitoring/risk`

## 5) Notifications Module

- Purpose: Queues customer transaction alerts (SMS/Email/Push integration point).
- Package: `com.bank.secure.backend.notification`

## 6) Audit & Compliance Module

- Purpose: Captures transaction and event logs for compliance and investigation.
- Package: `com.bank.secure.backend.audit`

## 7) Platform Observability Module

- Purpose: Health and operations visibility via health endpoint and Spring Boot Actuator.
- Package: `com.bank.secure.backend.health`
- Exposed APIs:
  - `GET /api/v1/health`

## Suggested Microservice Split (for future decomposition)

- `identity-service` -> auth module
- `account-service` -> account module
- `payment-service` -> transaction module
- `risk-monitoring-service` -> monitoring module
- `notification-service` -> notification module
- `audit-service` -> audit module
