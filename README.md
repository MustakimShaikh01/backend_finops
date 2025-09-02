# Spring Boot Factory CRUD

Minimal Spring Boot backend demonstrating CRUD operations with a Factory design pattern.

## Features
- CRUD REST endpoints for `BasicData`.
- Factory (`BasicDataServiceFactory`) to pick the service implementation.
- Default implementation: in-memory store (temporary data).
- Ready to swap in a JPA-based service later.

## Requirements
- Java 17+
- Maven 3.6+

## Run locally

```bash
# build
mvn clean package

# run
java -jar target/spring-boot-factory-crud-0.0.1-SNAPSHOT.jar
```

## API Endpoints

Base path: `/api/v1/basic-data`

- `POST /api/v1/basic-data` — create { name, value }
- `GET /api/v1/basic-data` — list all
- `GET /api/v1/basic-data/{id}` — get by id
- `PUT /api/v1/basic-data/{id}` — update
- `DELETE /api/v1/basic-data/{id}` — delete

## Push to GitHub

```bash
git init
git add .
git commit -m "Initial Spring Boot Factory CRUD"
# create repo on GitHub then
git remote add origin https://github.com/MustakimShaikh01/backend_finops.git
git push -u origin main
```

## To extend
- Add a `JpaBasicDataService` implementing `BasicDataService` and switch the factory to return it based on Spring profile or config.
- Add DTO mappers (MapStruct) and validation groups.
- Add integration tests.
# backend_finops
