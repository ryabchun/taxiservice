<%@ page import="com.example.taxiservice.model.Driver" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.taxiservice.model.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Driver to Car</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Add Driver to Car</h1>
<form action="<%= request.getContextPath() %>/add-driver-to-car" method="post">
    <label for="driverId">Select a Driver:</label>
    <select name="driverId" id="driverId">
        <% List<Driver> drivers = (List<Driver>) request.getAttribute("drivers");
            for (Driver driver : drivers) { %>
        <option value="<%= driver.getId() %>"><%= driver.getName() %></option>
        <% } %>
    </select><br>
    <label for="carId">Select a Car:</label>
    <select name="carId" id="carId">
        <% List<Car> cars = (List<Car>) request.getAttribute("cars");
            for (Car car : cars) { %>
        <option value="<%= car.getId() %>"><%= car.getModel() %></option>
        <% } %>
    </select><br>
    <button type="submit">Add Driver to Car</button>

</form>
<ul>
    <li><a href="${pageContext.request.contextPath}/">Main</a></li>
</ul>
</body>
</html>
