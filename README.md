# Kanban — Spring Boot Refactor

A task tracker (Kanban board) originally built on a hand-rolled Java HTTP server,
re-engineered as a modular Spring Boot application.

## About

The original [java-kanban](https://github.com/D1R3kT/java-kanban) was written for
Yandex Practicum: it ran its own HTTP server (`com.sun.net.httpserver`), handled JSON
manually with Gson, and persisted tasks to CSV files. This repository rebuilds it on a
production-style stack to practice real-world backend architecture.

## What this project demonstrates

- **Multi-module Maven** project with a clean layered architecture
- **REST API on Spring Boot** — replacing the custom HTTP server
- **Separation of concerns**: domain model / business logic / web layer, with
  dependency direction enforced at module boundaries (`web → service → model`)
- **Production-style logging** — Logback, profile-aware, async, rolling files
- **CI-friendly Maven versioning** (`${revision}` + flatten plugin)

## Tech stack

- Java 21
- Spring Boot 3.3
- Maven (multi-module)
- Logback · Lombok
- JUnit 5

## Architecture

| Module | Responsibility |
|---|---|
| `kanban-model` | Domain entities & enums (`Task`, `Epic`, `SubTask`, `Status`) — no framework dependencies |
| `kanban-service` | Business logic (`TaskManager`, `HistoryManager`) |
| `kanban-web` | Spring Boot app, REST controllers, application entry point |

Dependency direction: `kanban-web → kanban-service → kanban-model`.
The domain and business layers know nothing about the web/transport layer.

## Getting started

### Prerequisites
- JDK 21
- Maven 3.9+

### Build & run
\`\`\`bash
mvn clean install
mvn -pl kanban-web spring-boot:run
\`\`\`
The app starts on http://localhost:8080

### Logging
Console by default; run with the `prod` profile for rolling file logs:
\`\`\`bash
mvn -pl kanban-web spring-boot:run -Dspring-boot.run.profiles=prod
\`\`\`

## Roadmap

- [x] Multi-module skeleton (model / service / web)
- [x] Logging setup (Logback, profiles)
- [ ] Port domain model
- [ ] Port business logic (`TaskManager`, `HistoryManager`)
- [ ] REST controllers
- [ ] Persistence layer
- [ ] Tests (JUnit 5)