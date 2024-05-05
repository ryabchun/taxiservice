<%@ page import="com.example.taxiservice.model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturers</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Manufacturers</h1>
<ul>
    <% String contextPath = request.getContextPath(); %>
    <% List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
        for (Manufacturer manufacturer : manufacturers) { %>
    <li>
        <%= manufacturer.getName() %> (Country: <%= manufacturer.getCountry() %>)
        <form action="<%= contextPath %>/manufacturer/delete" method="post">
            <input type="hidden" name="id" value="<%= manufacturer.getId() %>" />
            <button type="submit">Delete</button>
        </form>
    </li>
    <% } %>
</ul>
<ul>
    <li><a href="${pageContext.request.contextPath}/manufacturer/register">Register New Manufacturer</a></li>
    <li><a href="<%= contextPath %>/">Main</a></li>
</ul>
</body>
</html>
