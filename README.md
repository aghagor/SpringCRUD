# SpringCRUD

Spring Boot CRUD demo is demonstrating how to implement simple CRUD operations with a `Product` entity.

## What's inside 
This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project and uses these packages :
- Maven
- Java
- Spring Core
- Spring Data (Hibernate & MySQL)
- Spring MVC (Tomcat)

## Installation 
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration 
Create a MySQL database with the name `springDB` and add the credentials to `/webapp/WEB-INF/spring-servlet.xml`.  
The default ones are :

```
spring.datasource.url=jdbc:mysql://localhost:3306/springdb
spring.datasource.username=root
spring.datasource.password=
```

## Usage 
Run the project through the IDE and head out to [http://localhost:8080](http://localhost:8080)

or 

run this command in the command line:
```
mvn spring-boot:run
```
