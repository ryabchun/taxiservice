# Taxi Service Project

I have created this "Taxi Service" project to demonstrate my expertise in Java Core, object-oriented programming, and web technology. In this web application, you can register or authenticate a driver, create a new car or manufacturer that will be added to the database. Additionally, in this app, you can add a driver to a car and look at the list of all cars that our driver uses.

### Features
- Register a new driver, car, or manufacturer.
- Assign a driver to a car.
- View a list of all drivers, cars, and manufacturers.
- Delete existing data.

### Technologies

In this project, the following technologies have been used:

- **Maven 3.1.1**
- **Java 11**
- **MySQL**
- **Tomcat **
- **Javax.servlet API**

## Getting Started

### Prerequisites
- Java
- MySQL
- Apache Tomcat 9.0.54+
- Apache Maven 3.1.1+

## To start a project by your own you must have:
1️⃣ IDE for Java.

2️⃣ MySQL or other DBMS (but you mush correct class ConnectionUtil and your DB).

3️⃣ Create your database using init_db.sql file located in src/main/resources/init_db.sql

4️⃣ Configure connection to DB for:
src/main/java/com.example.taxiservice/util/ConnectionUtil.java
```java
    private static final String URL = "url DB";
    private static final String USERNAME = "YOUR_USERNAME";
    private static final String PASSWORD = "YOUR_PASSWORD";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; (or you can use different one)
```

5️⃣ Run Tomcat 🚀
