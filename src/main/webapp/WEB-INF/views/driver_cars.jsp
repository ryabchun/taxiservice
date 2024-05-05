<%@ page import="com.example.taxiservice.model.Car" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Cars</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Your Cars</h1>
<ul>
    <% List<Car> cars = (List<Car>) request.getAttribute("cars");
        if (cars != null && !cars.isEmpty()) {
            for (Car car : cars) { %>
    <li><%= car.getModel() %></li>
    <%     }
    } else { %>
    <li>No cars found.</li>
    <% } %>
</ul>
<ul>
    <li><a href="<%= request.getContextPath() %>">Back to Main Page</a></li>
    <li><a href="${pageContext.request.contextPath}/">Main</a></li>
</ul>
</body>
</html>
