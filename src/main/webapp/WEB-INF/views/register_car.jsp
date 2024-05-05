<%@ page import="com.example.taxiservice.model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Car</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Register New Car</h1>
<form action="${pageContext.request.contextPath}/car/register" method="post">
    <label>Model:</label>
    <input type="text" name="model" required><br>
    <label>Manufacturer:</label>
    <select name="manufacturerId">
        <% List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
            for (Manufacturer manufacturer : manufacturers) { %>
        <option value="<%= manufacturer.getId() %>"><%= manufacturer.getName() %></option>
        <% } %>
    </select><br>
    <button type="submit">Register</button>
</form>
<ul>
    <li><a href="${pageContext.request.contextPath}/cars">Back to Cars List</a></li>
    <li><a href="${pageContext.request.contextPath}/">Main</a></li>
</ul>
</body>
</html>
