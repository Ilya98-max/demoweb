<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>user_data</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-top: 50px;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>Phone Number</th>
        <th>Last Name</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.phoneNumber}</td>
            <td>${user.lastName}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="db-servlet" method="GET">
    <input type="hidden" name="command" value="back"/>
    <input type="submit" value="Back"/>
</form>
</body>
</html>

