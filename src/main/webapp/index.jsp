<%@ page import="com.example.taxiservice.model.Driver" %><%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--&lt;%&ndash;<html>&ndash;%&gt;--%>
<%--&lt;%&ndash;<head>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <title>Main Page</title>&ndash;%&gt;--%>
<%--&lt;%&ndash;</head>&ndash;%&gt;--%>
<%--&lt;%&ndash;<body>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h1>Welcome to the Taxi Service</h1>&ndash;%&gt;--%>

<%--&lt;%&ndash;<!-- Display Links -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2>Display All</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;<ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <li><a href="<%= request.getContextPath() %>/drivers">Display All Drivers</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <li><a href="<%= request.getContextPath() %>/cars">Display All Cars</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <li><a href="<%= request.getContextPath() %>/manufacturers">Display All Manufacturers</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;</ul>&ndash;%&gt;--%>

<%--&lt;%&ndash;<!-- Create Links -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2>Create New</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;<ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <li><a href="<%= request.getContextPath() %>/driver/register">Create New Driver</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <li><a href="<%= request.getContextPath() %>/car/register">Create New Car</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <li><a href="<%= request.getContextPath() %>/manufacturer/register">Create New Manufacturer</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;</ul>&ndash;%&gt;--%>

<%--&lt;%&ndash;<!-- Additional Functionalities -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2>Other Functionalities</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;<ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <li><a href="<%= request.getContextPath() %>/car/add-driver">Add Driver to Car</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <li><a href="<%= request.getContextPath() %>/driver-cars">Display All Cars for Driver</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;</body>&ndash;%&gt;--%>
<%--&lt;%&ndash;</html>&ndash;%&gt;--%>


<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Main Page</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Welcome to the Taxi Service</h1>--%>

<%--<% Driver loggedDriver = (Driver) request.getSession().getAttribute("loggedDriver"); %>--%>

<%--<ul>--%>
<%--    <% if (loggedDriver == null) { %>--%>
<%--    <li><a href="<%= request.getContextPath() %>/login">Login</a></li>--%>
<%--    <% } else { %>--%>
<%--    <li><a href="<%= request.getContextPath() %>/logout">Logout</a></li>--%>
<%--    <li><a href="<%= request.getContextPath() %>/driver-cars">Display All Cars for Driver</a></li>--%>
<%--    <% } %>--%>

<%--    <!-- Display All links -->--%>
<%--    <li><a href="<%= request.getContextPath() %>/drivers">Display All Drivers</a></li>--%>
<%--    <li><a href="<%= request.getContextPath() %>/cars">Display All Cars</a></li>--%>
<%--    <li><a href="<%= request.getContextPath() %>/manufacturers">Display All Manufacturers</a></li>--%>

<%--    <!-- Create Links -->--%>
<%--    <li><a href="<%= request.getContextPath() %>/driver/register">Create New Driver</a></li>--%>
<%--    <li><a href="<%= request.getContextPath() %>/car/register">Create New Car</a></li>--%>
<%--    <li><a href="<%= request.getContextPath() %>/manufacturer/register">Create New Manufacturer</a></li>--%>

<%--    <li><a href="<%= request.getContextPath() %>/add-driver-to-car">Assign Driver to Car</a></li>--%>
<%--</ul>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/main.css">
</head>
<body>
<h1>Welcome to the Taxi Service</h1>

<% Driver loggedDriver = (Driver) request.getSession().getAttribute("loggedDriver"); %>

<ul>
    <% if (loggedDriver == null) { %>
    <li><a href="<%= request.getContextPath() %>/login">Login</a></li>
    <% } else { %>
    <li><a href="<%= request.getContextPath() %>/logout">Logout</a></li>
    <li><a href="<%= request.getContextPath() %>/driver-cars">Display All Cars for Driver</a></li>
    <% } %>

    <!-- Display All links -->
    <li><a href="<%= request.getContextPath() %>/drivers">Display All Drivers</a></li>
    <li><a href="<%= request.getContextPath() %>/cars">Display All Cars</a></li>
    <li><a href="<%= request.getContextPath() %>/manufacturers">Display All Manufacturers</a></li>

    <!-- Create Links -->
    <li><a href="<%= request.getContextPath() %>/driver/register">Create New Driver</a></li>
    <li><a href="<%= request.getContextPath() %>/car/register">Create New Car</a></li>
    <li><a href="<%= request.getContextPath() %>/manufacturer/register">Create New Manufacturer</a></li>

    <li><a href="<%= request.getContextPath() %>/add-driver-to-car">Assign Driver to Car</a></li>
</ul>
</body>
</html>
