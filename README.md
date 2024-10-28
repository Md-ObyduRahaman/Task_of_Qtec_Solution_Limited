# Product Management REST API

## Overview
This is a Product Management RESTful API designed for an eCommerce platform, implemented using Spring Boot and following Domain-Driven Design (DDD) principles. The API allows for the management of products, including operations to create, read, update, and delete products, as well as manage stock quantities.

## Architecture

The architecture follows DDD principles, ensuring that the domain logic is separated from infrastructure concerns. The main components are:

- **Domain Layer**: Contains the business logic and rules associated with the Product aggregate.
  - **Entities**: Represents the domain objects (e.g., Product).
  - **Value Objects**: (Optional) Can be used for specific attributes like Category or Discounts.
  - **Domain Services**: Contains business logic related to product management.

- **Application Layer**: Coordinates between the domain layer and infrastructure. It contains services that implement the business use cases for products.

- **Infrastructure Layer**: Implements the Repository Pattern to manage the persistence of products using Spring Data JPA with an H2 in-memory database.

## Technology Stack

- **Java**: Programming language used for development.
- **Spring Boot**: Framework for building the RESTful API.
- **Spring Data JPA**: For database interactions and repository management.
- **H2 Database**: In-memory database for development and testing.
- **Swagger**: For API documentation and testing.
- **Maven**: Build tool for dependency management.

## Features

- Create, retrieve, update, and delete products.
- Validate business rules such as:
  - Price must be a positive value.
  - Stock quantity must be a non-negative integer.
  - Product names must be unique.
- Pagination and sorting for retrieving products.
- Automatically generated API documentation using Swagger.

## API Endpoints

### 1. Get All Products
- **GET** `/products`
- Retrieves a list of all products.

### 2. Get Product by ID
- **GET** `/products/{id}`
- Retrieves a single product by its ID.

### 3. Create Product
- **POST** `/products`
- Creates a new product.
- **Request Body**:
  ```json
  {
      "name": "Product Name",
      "description": "Product Description",
      "price": 100.00,
      "stockQuantity": 10,
      "category": "Category Name"
  }
