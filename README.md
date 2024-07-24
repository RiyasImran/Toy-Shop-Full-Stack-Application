# Toy-Shop-Full-Stack-Application

## Overview

The **Toy-Shop** application is a full-stack web application designed for product management. It features a responsive and user-friendly interface developed with Angular, and a robust backend built with Spring Boot, Java, and MySQL. The application is aimed at enhancing user engagement by providing an efficient and interactive platform for managing toy products.

## Features

- **User Management**: Create, update, and delete user profiles.
- **Product Management**: Add, edit, and remove toy products.
- **Search and Filter**: Search and filter products based on various criteria.
- **Responsive Design**: Optimized for different screen sizes and devices.
- **Performance Optimization**: Ensures smooth and efficient user interactions.

## Technologies Used

### Frontend:

- Angular
- HTML5
- CSS3
- Bootstrap

### Backend:

- Java
- Spring Boot
- RESTful APIs

### Database:

- MySQL

### Tools:

- Git
- Maven/Gradle
- Postman (for API testing)

## Installation

### Prerequisites

- Node.js and npm
- Java JDK 11 or higher
- MySQL
- Maven/Gradle

### Frontend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/toy-shop-full-stack-application.git
2. Install dependencies:
   ```bash
   npm install
3. Start the Angular application:
   ```bash
   npm start

### Backend Setup

1. Navigate to the backend directory:
   ```bash
   cd toy-shop-full-stack-application/backend
2. Configure the application.properties file with your MySQL database credentials.
    ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/toyshop
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
3. Build the Spring Boot application:
    ```bash
    ./mvnw clean install
4. Start the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
### Usage

- **Frontend**: Open [http://localhost:4200](http://localhost:4200) in your browser to access the application.
- **Backend**: The Spring Boot server runs on [http://localhost:8080](http://localhost:8080) and provides RESTful APIs for the frontend.

### Contributing

Feel free to fork the repository and submit pull requests. For any issues or feature requests, please open an issue in the GitHub repository.

### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

### Acknowledgments

- Angular for the frontend framework.
- Spring Boot for the backend framework.
- MySQL for database management.