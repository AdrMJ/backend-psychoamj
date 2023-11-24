# Project PsychoAMJ Website

Backend wrote in Java for PsychoAMJ.

- [Java Frameworks](#java-frameworks)
- [Project Structure](#project-structure)
- [Database](#database)
- [Testing](#testing)
  - [JUnit](#junit)
  - [Mockito](#mockito)
- [Future](#future)
- [License](#license)

## Java Frameworks

- Spring
- JPA
- JDBC
- Lombok
- Hibernate
  
## Project Structure

This project is managed with Maven. When I created this project, I divided it into some folders. Let's talk about it:
 - 'constants' : The 'contants' storing messages, which I used for informing user about his mistakes. Keeping these messages centralized in one location makes it easier to manage and update error messages consistently across the application.
- 'models' : The 'models' holds the data models/entities used in the project. You can find there files like 'Authors.java', 'Book.java', 'Details.java', 'IntroWords.java' and 'Publication.java'.
- 'repository' : The 'repository' is responsible for including interface that extend Spring Data JPA repositories.
- 'rest' : In the 'rest' package, you will find REST controller interface. It contains HTTP request, manage data flow and interaction with the service layer.
- 'restImpl' : In the 'restImpl' class implements methods from 'rest'.
- 'service' : The 'service' package defines interface.
- 'serviceImpl' : The 'serviceImpl' have actual implementation of the service interface defined in the 'service' package.
- 'validation' : The 'validation' package include validator and class for custom validation annotation named "CorrectDate". 
- 'PsychoAmjApplication.java' : This class serves as the main entry point of the Spring Boot application.

## Database

This project uses MySql as underlying database. Structure of my database are located into 'database.sql' file. It was exported by [MySqlWorkbench](https://www.mysql.com/products/workbench/).

## Testing

This project includes a suite of tests to ensure the correctness and reliability of the code. The testing frameworks used are:
### [JUnit](https://junit.org/junit5/)
The test suite encompasses a variety of test methods, each addressing different scenarios. These tests not only verify the intended behavior of methods but also scrutinize potential error-prone areas. Through the use of JUnit, I aim to maintain a high level of code quality and robustness.

### [Mockito](https://site.mockito.org/)
This project utilizes it to enhance the testing process by creating mock objects and stubbing methods. Mockito is particularly useful for isolating components during testing, allowing me to focus on specific parts of the code without the need for the entire application to be running.

## Future
This project is a work in progress, and the primary focus has been on the backend written in Java. As the next step, I plan to create the frontend using Angular, which will be housed in a separate repository.

Future updates may include the addition of specific frontend components, such as background animations and font animations, which will be incrementally integrated into this project.

Stay tuned for further developments!

## License

This project is licensed under the [MIT License](https://opensource.org/license/mit/).
