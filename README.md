# E-commerce API

A simple REST API built with Spring Boot for managing products and categories.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL

## Project Structure

```
src/main/java/com/techlab/ecommerce/
├── controller/   # REST controllers
├── service/      # Business logic
├── repository/   # Data access (Spring Data JPA)
├── model/        # Entities
└── exception/    # Custom exceptions
```

## Endpoints
### Products

`GET http://localhost:8080/products`

`POST http://localhost:8080/products`
- Example:
```json
{
    "name": "Alfajor",
    "price": 800.0,
    "stock": 25,
    "category": { "id": 1 }
}
```
`PUT http://localhost:8080/products/{id}`
- Example:
```json
{   
    "stock": 20,
    "name": "Alfajor",
    "price": 900.0,
    "category": { "id": 1 }
}
```
`DELETE http://localhost:8080/products/{id}`


### Cateogories
`GET http://localhost:8080/categories`

`POST http://localhost:8080/categories`
- Example JSON:
```json
{
    "name": "Snacks",
    "description": "Snack products"
}
```
`PUT http://localhost:8080/categories/{id}`
- Example:
```json
{
    "name": "Sweets",
    "description": "Sweet products"
}
```
`DELETE http://localhost:8080/categories/{id}`

