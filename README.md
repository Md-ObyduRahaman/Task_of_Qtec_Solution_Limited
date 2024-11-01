# Product Management REST API

## Overview
This is a Product Management RESTful API designed for an eCommerce platform, implemented using Spring Boot and trying to following Domain-Driven Design (DDD) principles. The API allows for the management of products, including operations to create, read, update, and delete products, as well as manage stock quantities.

## Technology Stack

- **Java**: Programming language used for development.
- **Spring Boot**: Framework for building the RESTful API.
- **Spring Data JPA**: For database interactions and repository management.
- **H2 Database**: In-memory database for development and testing.
- **Swagger**: For API documentation and testing.
- **Maven**: Build tool for dependency management.

## Swagger Documentation
For interactive API documentation, visit the Swagger UI at: [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

## Postman Collection
The Postman collection for the Product Management API is available in the **resource folder** as `ProductManagementApiApplication.postman_collection.json`. Please check the file for all API requests and examples.

## Features

- Create, retrieve, update, and delete products.
- Validate business rules such as:
  - Price must be a positive value.
  - Stock quantity must be a non-negative integer.
  - Product names must be unique.
- Pagination and sorting for retrieving products.
- Automatically generated API documentation using Swagger.


## API Endpoints

### 1. Save Product
- **Endpoint:** `/api/products`
- **Method:** `POST`
- **Description:** Creates a new product in the system.
- **Request Body (JSON):**
  ```json
   {
        "name": "Sample Product 1",
        "description": "A sample product for testing",
        "price": 19.99,
        "category": "Electronics",
        "inventory": {
            "stockQuantity": 100
        }
    }
### 2. Fetch All Products
- **Endpoint:** `/api/products`
- **Method:** `GET`
- **Description:** Retrieves a paginated list of all products.
- **Query Parameters:**
  - `page` (default `0`): The page number.
  - `size` (default `10`): The number of products per page.
  - `sortBy` (default `name`): The attribute by which to sort.
  - `sortDirection` (default `asc`): Sort order, either `asc` or `desc`.
- **Example URL:** `http://localhost:8080/api/products?page=0&size=10&sortBy=name&sortDirection=asc`
### 3. Fetch Product by ID
- **Endpoint:** `/api/products/{id}`
- **Method:** `GET`
- **Description:** Fetches details of a specific product by its ID.
- **Example URL:** `http://localhost:8080/api/products/2`
### 4. Update Product
- **Endpoint:** `/api/products/{id}`
- **Method:** `PUT`
- **Description:** Updates an existing product by its ID.
- **Request Body (JSON):**
  ```json
   {
        "name": "Sample Product 1",
        "description": "A sample product for testing",
        "price": 19.99,
        "category": "Electronics",
        "inventory": {
            "stockQuantity": 100
        }
    }

### 5. Update Product Stock
- **Endpoint:** `/api/products/{id}/update-stock`
- **Method:** `PATCH`
- **Description:** Updates the stock quantity of a specific product.
- **Request Body (Form Data):**
  - `quantity`: The new stock quantity for the product.
- **Example URL:** `http://localhost:8080/api/products/1/update-stock`
### 6. Delete Product
- **Endpoint:** `/api/products/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a product by its ID.
- **Example URL:** `http://localhost:8080/api/products/3`
