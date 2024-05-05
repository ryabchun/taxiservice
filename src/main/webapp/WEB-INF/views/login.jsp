<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Login</h1>
<form action="<%= request.getContextPath() %>/login" method="post">
    <label>Login:</label>
    <input type="text" name="login" required><br>
    <label>Password:</label>
    <input type="password" name="password" required><br>
    <button type="submit">Login</button>
</form>
<% if (request.getAttribute("errorMessage") != null) { %>
<p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
<% } %>
</body>
</html>
