<%@ page import="com.example.taxiservice.model.Driver" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drivers</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Drivers</h1>
<ul>
    <% String contextPath = request.getContextPath(); %>
    <% List<Driver> drivers = (List<Driver>) request.getAttribute("drivers");
        for (Driver driver : drivers) { %>
    <li>
        <%= driver.getName() %> (License: <%= driver.getLicenseNumber() %>)
        <form action="<%= contextPath %>/driver/delete" method="post">
            <input type="hidden" name="id" value="<%= driver.getId() %>" />
            <button type="submit">Delete</button>
        </form>
    </li>
    <% } %>
</ul>
<ul>
    <li><a href="<%= contextPath %>/driver/register">Register New Driver</a></li>
    <li><a href="<%= contextPath %>/">Main</a></li>
</ul>
</body>
</html>
