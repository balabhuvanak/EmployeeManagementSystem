# Employee Management System

## Overview
A Spring Boot REST API application for managing employee records. The application provides CRUD operations and employee search functionality using Spring Data JPA and MySQL.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs
- Git & GitHub

## Features

- Create Employee
- Get Employee By ID
- Get All Employees
- Update Employee
- Delete Employee
- Search Employee By Email
- Search Employees By Department

## Project Structure

src/main/java
├── controller
├── service
├── dao
├── model
└── EmployeeManagementSystemApplication

## API Endpoints

### Create Employee

POST /employee/save

### Get All Employees

GET /employee

### Get Employee By ID

GET /employee/{id}

### Update Employee

PUT /employee/{id}

### Delete Employee

DELETE /employee/{id}

### Search By Email

GET /employee/email/{email}

### Search By Department

GET /employee/department/{department}

## Database

Database: EmployeeManagementDb

Table: employee

Columns:
- id
- name
- email
- department
- salary

## Future Enhancements

- DTO Layer
- Validation
- Global Exception Handling
- Pagination & Sorting
- Swagger Documentation
- Unit Testing

## Author

Bhuvana
