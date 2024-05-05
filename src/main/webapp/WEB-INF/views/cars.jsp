<%@ page import="com.example.taxiservice.model.Car" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Cars</h1>
<ul>
    <% String contextPath = request.getContextPath(); %>
    <% List<Car> cars = (List<Car>) request.getAttribute("cars");
        for (Car car : cars) { %>
    <li>
        <%= car.getModel() %> (Manufacturer: <%= car.getManufacturer().getName() %>)
        <form action="<%= contextPath %>/car/delete" method="post">
            <input type="hidden" name="id" value="<%= car.getId() %>" />
            <button type="submit">Delete</button>
        </form>
    </li>
    <% } %>
</ul>
<ul>
    <li><a href="${pageContext.request.contextPath}/car/register">Register New Car</a></li>
    <li><a href="<%= contextPath %>/">Main</a></li>
</ul>

</body>
</html>
