## Definition
```text
The Calculator API PROJECT is a comprehensive calculator application built with Maven, Spring Boot, and design patterns.
It offers a user-friendly interface, RESTful API, and backend persistence, enabling extensibility and scalability. 
Explore modern software development practices and design patterns with this project.
```
## Design Patterns
```text
The calculator project incorporates several design patterns to enhance its structure and functionality.
It utilizes the Factory pattern to create different calculator objects,
the Facade pattern to provide a simplifiedinterface for client code, 
the Data Transfer Object (DTO) pattern for efficient data transfer, 
the Singleton pattern for managing Spring components,
the Template Method pattern for reusable controller methods, 
and potentially the Builder pattern for future enhancements. 
These design patterns contribute to the project's modularity, extensibility, and maintainability.
```

## Project Structure
```text
src/main/java
└── com
    └── example
        └── calculator
            ├── CalculatorApplication.java
            ├── controller
            │   ├── ArithmeticController.java
            │   ├── AccountsController.java
            │   └── ScientificController.java
            ├── dto
            │   ├── AccountsRequestDTO.java
            │   ├── ArithmeticRequestDTO.java
            │   └── ScientificRequestDTO.java
            ├── model
            │   ├── AccountsResponse.java
            │   ├── ArithmeticResponse.java
            │   └── ScientificResponse.java
            ├── factory
            │   ├── AccountsFactory.java
            │   ├── ArithmeticFactory.java
            │   └── ScientificFactory.java
            ├── facade
            │   ├── arithmetic
            │   │   ├── AdditionArithmeticFacade.java
            │   │   ├── SubtractionArithmeticFacade.java
            │   │   ├── MultiplicationArithmeticFacade.java
            │   │   └── DivisionArithmeticFacade.java
            │   ├── accounts
            │   │   ├── SimpleInterestAccountsFacade.java
            │   │   └── CompoundInterestAccountsFacade.java
            │   └── scientific
            │       ├── BodmasScientificFacade.java
            │       ├── TrigonometryScientificFacade.java
            ├── service
            │   ├── AccountsService.java
            │   ├── ArithmeticService.java
            │   └── ScientificService.java
            ├── validation
            │   ├── GeneralRequestValidator.java
            │   ├── Validator.java
            │   └── validatorTypes
            │       ├── OperationValidator.java
            │       └── ValuesValidator.java
            ├── utils
            │   └── LoggerUtil.java
            └── exception
                ├── ValidationException.java
                ├── ErrorResponse.java
                └── GlobalExceptionHandler.java

src/main/resources
├── application.properties

pom.xml
README.md


```

## Description


## Components

### CalculatorApplication.java

The main class that starts the Calculator Application.

### Controllers

- ArithmeticController.java: Controller class for handling arithmetic operations.
- AccountsController.java: Controller class for handling accounts operations.
- ScientificController.java: Controller class for handling scientific operations.

### DTOs

- AccountsRequestDTO.java: Data Transfer Object for accounts-related requests.
- ArithmeticRequestDTO.java: Data Transfer Object for arithmetic-related requests.
- ScientificRequestDTO.java: Data Transfer Object for scientific-related requests.

### Models

- AccountsResponse.java: Model class for accounts-related responses.
- ArithmeticResponse.java: Model class for arithmetic-related responses.
- ScientificResponse.java: Model class for scientific-related responses.

### Factories

- AccountsFactory.java: Factory class for creating accounts-related calculator instances.
- ArithmeticFactory.java: Factory class for creating arithmetic-related calculator instances.
- ScientificFactory.java: Factory class for creating scientific-related calculator instances.

### Facades

- Arithmetic:
    - AdditionArithmeticFacade.java: Facade class for performing addition operations.
    - SubtractionArithmeticFacade.java: Facade class for performing subtraction operations.
    - MultiplicationArithmeticFacade.java: Facade class for performing multiplication operations.
    - DivisionArithmeticFacade.java: Facade class for performing division operations.

- Accounts:
    - SimpleInterestAccountsFacade.java: Facade class for calculating simple interest.
    - CompoundInterestAccountsFacade.java: Facade class for calculating compound interest.

- Scientific:
    - BodmasScientificFacade.java: Facade class for performing BODMAS operations.
    - TrigonometryScientificFacade.java: Facade class for performing trigonometry operations.

### Services

- AccountsService.java: Service class for handling accounts-related operations.
- ArithmeticService.java: Service class for handling arithmetic-related operations.
- ScientificService.java: Service class for handling scientific-related operations.

### Validation

- GeneralRequestValidator.java: Validator class for general request validation.
- Validator.java: Interface for request validation.
- validatorTypes:
    - OperationValidator.java: Validator class for validating operations.
    - ValuesValidator.java: Validator class for validating values.

### Utils

- LoggerUtil.java: Utility class for logging.

### Exceptions

- ValidationException.java: Custom exception class for validation errors.
- ErrorResponse.java: Model class for error responses.
- GlobalExceptionHandler.java: Global exception handler for handling exceptions.

### Resources

- application.properties: Configuration properties for the application.

## Dependencies

The calculator application requires the following dependencies:

- Spring Boot: Framework for building Java applications.
- Spring Web: Library for building web applications using Spring.
- Spring Validation: Library for request validation.
- SLF4J: Simple Logging Facade for Java.
- Lombok: Library for reducing boilerplate code.
- Jackson: Library for working with JSON data.
- H2 Database: In-memory database for development purposes.

## Getting Started

To run the calculator application, follow these steps:

1. Make sure you have Java and Maven installed on your machine.
2. Clone the project from the repository.
3. Build the project using Maven: `mvn clean install`.
4. Run the application: `mvn spring-boot:run`.
5. The application will start running on the default port (8080).
6. You can access the API endpoints using tools like Postman or curl.

## API Endpoints

The calculator application provides the following API endpoints:

- Arithmetic Operations:
    - POST /api/calculator/arithmetic/addition
    - POST /api/calculator/arithmetic/subtraction
    - POST /api/calculator/arithmetic/multiplication
    - POST /api/calculator/arithmetic/division

- Accounts Operations:
    - POST /api/calculator/accounts/simple-interest
    - POST /api/calculator/accounts/compound-interest

- Scientific Operations:
    - POST /api/calculator/scientific/bodmas
    - POST /api/calculator/scientific/trigonometry

Refer to the API documentation or explore the controller classes for more details on the request and response structures.