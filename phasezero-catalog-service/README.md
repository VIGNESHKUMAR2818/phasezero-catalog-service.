# PhaseZero Catalog Service

A Spring Boot REST API for managing product catalog data.

## Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Maven

## Features
- Add new products
- Fetch all products
- Input validation
- Global exception handling

## API Endpoints

### Add Product
POST /products

Request Body:
```json
{
  "partNumber": "P001",
  "partName": "Hydraulic Filter",
  "category": "Engine",
  "price": 1200.0,
  "stock": 10
}