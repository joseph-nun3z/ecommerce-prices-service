# E-commerce Prices Service

This Spring Boot WebFlux application provides a reactive API for managing e-commerce product prices, including features for importing, updating, and querying prices based on product and brand identifiers within specific date ranges.

## Key Features

- **Reactive API Endpoints**: Utilizes Spring WebFlux for non-blocking API requests, improving scalability and performance under load.
- **Database Access**: Integrates with R2DBC for reactive database access, supporting CRUD operations on prices in an asynchronous manner.
- **Swagger/OpenAPI Documentation**: Implements `springdoc-openapi` for automatic generation of API documentation, accessible via Swagger UI.
- **Bulk Operations**: Supports adding multiple prices in a single request, simplifying batch processing tasks.
- **JWT Authentication**: (Planned, not implemented) Intended to secure API endpoints using JSON Web Tokens for stateless authentication.

## Technologies Used

- **Spring Boot**: For rapid application development and its reactive stack.
- **Spring WebFlux**: For building reactive and non-blocking web applications.
- **R2DBC**: For reactive database access, allowing for non-blocking database operations.
- **Spring Security**: (Planned) For securing API endpoints.
- **H2 Database**: In-memory SQL database for development and testing.
- **Swagger/OpenAPI**: For API documentation and interactive exploration of API endpoints.

## Running the Application

To run the application, use the following command:

```bash
mvn spring-boot:run
```

## Accessing API Documentation

Once the application is running, the API documentation can be accessed through Swagger UI at:

```
http://localhost:8080/swagger-ui/index.html
```

## API Endpoints

- **Import Prices**: `POST /final-price` - Accepts a list of prices for bulk creation.
- **Query Prices**: `GET /final-price` - Retrieves prices based on query parameters like `productId`, `brandId`, and `dateTime`.

## Database Schema

The application uses an H2 in-memory database with an auto-incremented `id` for the `prices` table, ensuring unique identifiers for each price entry.

## Future Enhancements

- Implement JWT authentication to secure API endpoints.
- Expand testing coverage to include more comprehensive integration and unit tests.
- Consider implementing a caching strategy for frequently queried data to improve performance.
