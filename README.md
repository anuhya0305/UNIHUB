# UNIHUB

A University Resource Management Platform built with Spring Boot, Spring Data JPA, and MySQL. Students register, log in, and manage a shared catalog of university resources (title, subject, description) through full CRUD operations.

## Features

- User registration and login, with passwords hashed using BCrypt (`spring-security-crypto`)
- Resource catalog: add, view, edit, and delete resources
- Server-rendered UI with Thymeleaf templates

## Tech Stack

- Java 17, Spring Boot 3.2.5
- Spring Data JPA + Hibernate (ORM, no hand-written SQL)
- Thymeleaf (server-rendered views)
- MySQL
- Maven

## Project Structure

```
src/main/java/com/unihub/
 ├── controller/   # HomeController, LoginController, RegisterController, DashboardController, ResourceController
 ├── entity/       # User, Resource
 ├── repository/   # UserRepository, ResourceRepository (Spring Data JPA)
 ├── service/      # UserService, ResourceService + impl/
 └── UnihubApplication.java
src/main/resources/
 ├── application.properties
 ├── static/       # css, images
 └── templates/    # index, login, register, dashboard, resources, add-resource, edit-resource
```

## Routes

| Method | Path                    | Description               |
|--------|-------------------------|----------------------------|
| GET    | `/`                     | Landing page               |
| GET    | `/register`              | Registration form          |
| POST   | `/register`              | Create a new user          |
| GET    | `/login`                 | Login form                 |
| POST   | `/login`                 | Authenticate a user        |
| GET    | `/dashboard`              | Dashboard after login      |
| GET    | `/resources`              | List all resources         |
| GET    | `/resources/add`          | Add-resource form          |
| POST   | `/resources/add`          | Create a resource          |
| GET    | `/resources/edit/{id}`    | Edit-resource form         |
| POST   | `/resources/update`       | Update a resource          |
| GET    | `/resources/delete/{id}`  | Delete a resource          |

## Running Locally

1. Create a MySQL database:
   ```sql
   CREATE DATABASE unihub_db;
   ```
2. Set your database credentials as environment variables (the app reads them from `application.properties` via `${DB_USERNAME}` / `${DB_PASSWORD}` — nothing is hardcoded):
   ```bash
   export DB_USERNAME=root
   export DB_PASSWORD=your-mysql-password
   ```
   On Windows PowerShell:
   ```powershell
   $env:DB_USERNAME="root"
   $env:DB_PASSWORD="your-mysql-password"
   ```
3. Run the app:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Open `http://localhost:8080`.

Hibernate is configured with `spring.jpa.hibernate.ddl-auto=update`, so the `users` and `resources` tables are created automatically on first run.

## Notes

- Passwords are hashed with BCrypt before being persisted — never stored or compared in plaintext.
- Database credentials are supplied via environment variables rather than committed to source control.
