## Project name
### Spring Boot project for saving data from HTTP response to data base.

## Description
This is a mini project that loads JSON data from the HTTP REST server to the database. 
The code is covered by unit tests that check the functionality. I also implemented MVC, 
for the ability to display data on HTML pages.
1. The project is executed on SpringBoot.
2. Build Maven.
3. Http client OkHttp.
4. The DB of your choice, preferably postgres
5. Mockito Tests, Junit

## Table of Contents
* [Project name](#project-name)
* [Description](#description)
* [Technologies](#technologies)
* [Prerequisites](#prerequisites)
* [Installation and running](#installation-and-running)
* [General project requirements](#general-project-requirements)
* [EERD scheme](#EERD-scheme)
* [Architecture](#architecture)
* [Authors](#author)

### Technologies
* Maven
* Spring Boot
* PostgreSQL Data Base
* JDBC
* OkHTTP
* JUnit
* Mockito
* HTML

### Prerequisites
To run the project you need installed : 
  * Java 8 (jre/jdk) or higher version  
  * Apache Maven 3.0.1 or higher version
  * Intellij Idea (ultimate)
    
### Installation and running
To install and run the project on localhost: 
 * Install JDK, JRE, set parameters for environment variables. Install Apache Tomcat, install Apache Maven. 
 * Clone/fork or download the project [project](https://github.com/bestXakep/spring-boot-rest)  from the GitHub.
 * Add pom.xml file as Maven dependencies.

### General project requirements
You need to build a web application that supports the following functionality:
Based on the entities create classes that describe them.
Classes and methods must have a name reflecting their functionality and must be properly structured by package.
Information about the subject area is stored in the database, for access, use the JDBC API using a connection pool, 
standard or developed independently. MySQL is recommended as a DBMS.
The application should support working with Cyrillic (be multilingual), including storing information in the database.
The code must be documented.
The application must be covered by unit tests.
During developing business logic, use sessions and filters and process events in the system by Log4j.
In the application you need to implement Pagination, Transaction, depending on your project.
Using servlets and JSP, you have to implement the functionality proposed in the formulation of a specific task.
In JSP pages, use the JSTL library.
The application should react correctly when errors and exceptions occurs of various kinds (the User should never see 
the stack-trace on the front-end side).
The application must have an Authorization and Authentication system.

### EERD scheme

![alt text](https://github.com/Ray-ParkerDEV/Servlet_login_origin/blob/master/src/main/webapp/images/EERD.jpg)

### Architecture

![alt text](https://github.com/Ray-ParkerDEV/Servlet_login_origin/blob/master/src/main/webapp/images/architecture.jpg)

![alt text](https://github.com/Ray-ParkerDEV/TIME-TRACKER/blob/master/src/main/webapp/images/ex.jpg)
## Author
Bodyak Iaroslav (e-mail: [4456602@gmail.com](mailto:4456602@gmail.com))




