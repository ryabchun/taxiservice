<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Manufacturer</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Register New Manufacturer</h1>
<form action="${pageContext.request.contextPath}/manufacturer/register" method="post">
    <label>Name:</label>
    <input type="text" name="name" required><br>
    <label>Country:</label>
    <input type="text" name="country" required><br>
    <button type="submit">Register</button>
</form>
<ul>
    <li><a href="${pageContext.request.contextPath}/manufacturers">Back to Manufacturers List</a></li>
    <li><a href="${pageContext.request.contextPath}/">Main</a></li>
</ul>
</body>
</html>
