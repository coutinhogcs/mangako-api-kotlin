# Mangakō API 📖

[![Build Status](https://img.shields.io/travis/your-username/mangako-api.svg?style=for-the-badge)](https://travis-ci.org/your-username/mangako-api)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

The official backend API for **Mangakō**, a modern manga reader web application. This project provides a complete RESTful API built with Kotlin and Spring Boot to handle all the platform's data, from manga series to individual chapters.

## 🎯 About The Project

Mangakō API was created to be the solid foundation for a rich frontend experience. It centralizes all business logic and data persistence, exposing a clean, predictable, and well-structured set of endpoints.

### Key Features

-   ✅ **Manga Management**: Full CRUD operations for manga series.
-   ✅ **Chapter Population**: Add, update, and retrieve chapters for each manga.
-   ✅ **RESTful by Design**: Follows REST principles for a predictable API experience.
-   ✅ **DTO Pattern**: Safely exposes data to the client, separating the API contract from the database model.
-   ✅ **Ready to Scale**: Built on top of the robust and widely-used Spring Boot framework.

## 🛠️ Built With

This project leverages a modern and powerful tech stack:

-   **Language**: [Kotlin](https://kotlinlang.org/)
-   **Framework**: [Spring Boot](https://spring.io/projects/spring-boot)
-   **Data Persistence**: [Spring Data JPA](https://spring.io/projects/spring-data-jpa) & [Hibernate](https://hibernate.org/)
-   **Database**: [PostgreSQL](https://www.postgresql.org/)
-   **Build Tool**: [Maven](https://maven.apache.org/)

## 🚀 Getting Started

Follow these instructions to set up the project locally.

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/your-username/mangako-api.git](https://github.com/your-username/mangako-api.git)
    cd mangako-api
    ```
2.  **Configure the environment:**
    -   Copy the example configuration file: `cp .env.example .env`
    -   Modify the `.env` file or your `application.properties` with your database credentials.
3.  **Run the application:**
    ```sh
    ./mvnw spring-boot:run
    ```
    The API will start on `http://localhost:8080`.

##  API Endpoints

Here are some of the main endpoints available:

| Method | Endpoint                          | Description                             |
| :----- | :-------------------------------- | :-------------------------------------- |
| `GET`  | `/api/mangas`                     | Retrieves a list of all mangas.         |
| `POST` | `/api/mangas`                     | Creates a new manga.                    |
| `GET`  | `/api/mangas/{mangaId}`           | Gets a single manga by its ID.          |
| `POST` | `/api/mangas/{mangaId}/chapters`  | Adds a new chapter to a specific manga. |


## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.
