<%@ page import="com.example.demo.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.entity.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Data</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f2e9e4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h1 {
            color: #3e2723;
            text-align: center;
            margin: 50px 0 20px;
            font-size: 32px;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        th, td {
            border: 1px solid #d7ccc8;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #5d4037;
            color: #fff;
            border-color: #5d4037;
        }
        td {
            color: #5d4037;
        }
        a {
            font-family: 'Rock Salt', cursive;
            font-size: 18px;
            color: #3e2723;
            text-decoration: none;
            background-color: #f9fbe7;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #ffee58;
        }
    </style>
</head>
<body>

<h1>User Data</h1>

<table>
    <thead>
    <tr>
        <th>Phone Number</th>
        <th>Last Name</th>
        <th>Password</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<User> users = (List<User>) session.getAttribute("users");
    %>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.phoneNumber}</td>
            <td>${user.lastName}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<h2>Orders</h2>
<table>
    <thead>
    <tr>
        <th>Coffee Type</th>
        <th>Coffee Quantity</th>
        <th>Dessert Type</th>
        <th>Dessert Quantity</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Order> orders = (List<Order>) session.getAttribute("orders");
    %>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.coffeeType}</td>
            <td>${order.coffeeQuantity}</td>
            <td>${order.dessertType}</td>
            <td>${order.dessertQuantity}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p style="text-align: center;">
    <a href="../index.jsp">Go back to homepage</a>
</p>

</body>
</html>