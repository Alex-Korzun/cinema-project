# Online Theatre Service

Service for buying tickets online, where you can register as a User, buy tickets, see your Order history. Also, you can check all available Performances, Theatre Stages, find Session by date.

As Admin, you can also view all information about Users and find them by email.
## Technologies Used
- Java
- Maven
- Maven Checkstyle Plugin
- Hibernate
- Spring MVC
- Spring Security
- MySQL
- Tomcat

## Project Structure
Project have DAO layer which operates with information from DataBase, Service layer for correct business logic, controller layer for operating with Spring MVC, Security layer.
SOLID principles are all kept. Custom annotations for validation emails and passwords 

## Required Procedures for Running Application
1. Download and install the [JDK]( https://www.oracle.com/ru/java/technologies/javase-downloads.html).
2. Download and install servlet container (for example [Apache Tomcat](https://tomcat.apache.org/download-90.cgi,)).
3. Download and install [MySQL Server](https://dev.mysql.com/downloads/).
4. Find file 'db.properties' in package 'resources' and change the parameters that are valid for you:
    + url;
    + username: "username";
    + password: "password";
5. Run the project.

##Important Information
1. Default properties for Admin are:
    + email: "admin@gmail.com";
    + password: "admin";
2. If you want to change it, go to 'DataInitializer'.
