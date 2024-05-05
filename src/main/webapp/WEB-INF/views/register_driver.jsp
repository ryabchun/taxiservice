<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Driver</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Register New Driver</h1>
<form action="${pageContext.request.contextPath}/driver/register" method="post">
    <label>Name:</label>
    <input type="text" name="name" required><br>
    <label>License Number:</label>
    <input type="text" name="licenseNumber" required><br>
    <label>Login:</label>
    <input type="text" name="login" required><br>
    <label>Password:</label>
    <input type="password" name="password" required><br>
    <button type="submit">Register</button>
</form>

<ul>
    <li><a href="${pageContext.request.contextPath}/drivers">Back to Drivers List</a></li>
    <li><a href="${pageContext.request.contextPath}/">Main</a></li>
</ul>
</body>
</html>
