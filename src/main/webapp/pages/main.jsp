<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/tags.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <style>
        body {
            background-color: #fdf5e6;
            color: #3e2723;
            font-family: 'Georgia', serif;
            transition: background-color 0.3s, color 0.3s;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .header, .footer {
            text-align: center;
            padding: 10px 0;
            background-color: #6f4e37;
            color: white;
            border-bottom: 2px solid #4d3319;
            width: 100%;
        }
        .header h1 {
            margin: 0;
        }
        .header-content {
            margin-bottom: 20px;
        }
        .content {
            padding: 20px;
            text-align: center;
            width: 100%;
            max-width: 600px;
            margin: 20px auto;
        }
        .menu-btn, .logout-btn {
            padding: 12px 24px;
            border: none;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px 0;
            cursor: pointer;
            transition: background-color 0.3s, color 0.3s;
            background-color: #8d6e63;
            color: white;
            outline: none;
        }
        .menu-btn:hover {
            background-color: #9c7e71;
        }
        .logout-btn {
            background-color: #6f4e37;
            color: white;
            position: absolute;
            bottom: 10px;
            right: 10px;
        }
        .logout-btn:hover {
            background-color: #8d6e63;
        }
        #current-time {
            font-size: 18px;
            font-weight: bold;
            margin-top: 20px;
            text-align: center;
        }
        .footer {
            background-color: #6f4e37;
            color: white;
            text-align: center;
            padding: 10px 0;
            width: 100%;
        }
        .footer a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
            transition: color 0.3s;
        }
        .footer a:hover {
            color: #9c7e71;
        }
    </style>
    <script>

        var userName = '<%= session.getAttribute("login") %>';


        document.addEventListener('DOMContentLoaded', function() {
            document.getElementById('user-greeting').innerText = 'Welcome, ' + userName + '!';
        });


        function redirectToOrderPage() {
            window.location.href = 'order-page.jsp';
        }
    </script>
</head>
<body>
<div class="header">
    <div class="header-content">
        <h1>The Best Coffee in Town</h1>
        <p>Fresh and Delicious Pastries</p>
        <p id="user-greeting"></p>
    </div>
</div>
<div class="container">
    <div class="content">
        <button class="menu-btn" onclick="redirectToOrderPage()">Menu Page</button>
        <form action="db-servlet" method="post" style="display:inline;">
            <input type="hidden" name="command" value="logout"/>
            <input type="submit" class="logout-btn" value="Logout"/>
        </form>
    </div>
</div>
<custom:customTag/>
<div class="footer">
    <a href="partners.jsp">Partners</a>
    <a href="about.jsp">About Us</a>
    <a href="contact.jsp">Contact Us</a>
    <p>&copy; 2024 The Coffee House </p>
</div>
</body>
</html>
