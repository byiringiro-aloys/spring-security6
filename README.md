# Spring Security 6 with JWT Authentication

## Overview

This project demonstrates a comprehensive implementation of Spring Security 6 with JWT (JSON Web Token) authentication and authorization. It's designed as a learning project to master Spring Security concepts including custom authentication, JWT token management, and secure API endpoints.

## Features

- **JWT-based Authentication**: Secure token-based authentication system
- **Custom User Management**: User registration and login with encrypted passwords
- **Role-based Authorization**: User roles and permissions management
- **Stateless Security**: Session-less authentication using JWT tokens
- **OAuth2 Integration**: Support for OAuth2 login flows
- **Secure API Endpoints**: Protected REST endpoints with authentication requirements
- **Password Encryption**: BCrypt password hashing for security

## Technology Stack

- **Framework**: Spring Boot 3.5.4
- **Language**: Java 24
- **Security**: Spring Security 6
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Lombok**: For reducing boilerplate code
- **JWT**: JSON Web Token implementation

## Project Structure

```
src/main/java/com/spring_sec/SpringSec1/
├── config/                 # Security configuration classes
│   ├── WebSecurityConfig.java           # Main security configuration
│   ├── JwtAuthenticationFilter.java     # JWT token validation filter
│   └── JwtAuthenticationSuccessHandler.java # OAuth2 success handler
├── service/                # Business logic services
│   ├── JwtService.java                  # JWT token operations
│   ├── UserService.java                 # User management
│   ├── CustomUserDetailsService.java    # Custom user details service
│   └── HomeService.java                 # Home page service
├── Controllers/            # REST API controllers
│   ├── UserController.java              # User authentication endpoints
│   ├── HomeController.java              # Home page endpoints
│   └── ProductController.java           # Product management endpoints
├── entity/                 # JPA entities
│   └── Users.java                      # User entity
├── repository/             # Data access layer
│   └── UserRepository.java             # User data operations
└── CustomUserDetails.java  # Custom user details implementation
```

## Security Configuration

### Authentication Flow
1. **User Registration**: Users register with username/password (stored encrypted)
2. **User Login**: Authentication via Spring Security's AuthenticationManager
3. **JWT Generation**: Upon successful authentication, JWT token is generated
4. **Token Validation**: Subsequent requests are validated using JWT filter
5. **OAuth2 Support**: Optional OAuth2 login with JWT token generation

### Security Features
- CSRF protection disabled for API endpoints
- Stateless session management
- JWT token validation on each request
- Custom authentication provider
- Role-based access control

## API Endpoints

### Public Endpoints (No Authentication Required)
- `POST /register` - User registration
- `POST /login` - User authentication

### Protected Endpoints (Authentication Required)
- `GET /` - Home page
- `GET /products` - List all products
- `POST /products` - Create new product
- `GET /csrf` - CSRF token endpoint

### Authentication Endpoints
- `POST /register` - Register new user
  ```json
  {
    "username": "user@example.com",
    "password": "password123"
  }
  ```
- `POST /login` - Authenticate user
  ```json
  {
    "username": "user@example.com",
    "password": "password123"
  }
  ```

## JWT Token Structure

The JWT tokens include:
- **Subject**: Username
- **Issuer**: "Aloys"
- **Issued At**: Token creation timestamp
- **Expiration**: 10 minutes from creation
- **Claims**: Additional user information

## Running the Project

### Prerequisites
- Java 24 or higher
- Maven 3.6+
- PostgreSQL database
- IDE (IntelliJ IDEA recommended)

### Setup Steps
1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd SpringSec1
   ```

2. **Database Configuration**
   - Create PostgreSQL database
   - Update `application.properties` with database credentials

3. **Dependencies**
   - Open project in IntelliJ IDEA
   - Maven will automatically download dependencies
   - Or run: `mvn clean install`

4. **Configuration**
   - Set `secretKey` property in `application.properties`
   - Configure database connection properties

5. **Run the Application**
   - Run `SpringSec1Application.java` from IDE
   - Or use: `mvn spring-boot:run`

### Environment Variables
```properties
# JWT Configuration
secretKey=your-base64-encoded-secret-key-here

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Testing the API

### 1. Register a User
```bash
curl -X POST http://localhost:8080/register \
  -H "Content-Type: application/json" \
  -d '{"username": "test@example.com", "password": "password123"}'
```

### 2. Login and Get JWT Token
```bash
curl -X POST http://localhost:8080/login \
  -H "Content-Type: application/json" \
  -d '{"username": "test@example.com", "password": "password123"}'
```

### 3. Access Protected Endpoint
```bash
curl -X GET http://localhost:8080/products \
  -H "Authorization: Bearer YOUR_JWT_TOKEN_HERE"
```

## Security Considerations

- **Password Security**: All passwords are encrypted using BCrypt with strength 14
- **Token Expiration**: JWT tokens expire after 10 minutes for security
- **Stateless Design**: No server-side session storage
- **Header-based Authentication**: JWT tokens sent via Authorization header

## Learning Objectives

This project covers:
- Spring Security 6 configuration and customization
- JWT token implementation and management
- Custom authentication providers
- User details service implementation
- OAuth2 integration with Spring Security
- Secure REST API development
- Database security and password encryption

## Troubleshooting

### Common Issues
1. **JWT Token Expired**: Tokens expire after 10 minutes, re-authenticate
2. **Database Connection**: Verify PostgreSQL is running and credentials are correct
3. **Secret Key**: Ensure `secretKey` property is set in `application.properties`
4. **Port Conflicts**: Default port is 8080, change if needed

### Logs
Check application logs for detailed error information and debugging.

## Contributing

This is a learning project. Feel free to:
- Report issues
- Suggest improvements
- Fork and experiment
- Share your learnings

## License

This project is for educational purposes. Use responsibly and in accordance with Spring Security best practices.
