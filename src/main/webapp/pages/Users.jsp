<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7f7f7;
            color: #6c757d;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        h1 {
            font-size: 32px;
            text-align: center;
            color: #4e342e;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 20px;
        }
        input[type="submit"] {
            background-color: #795548;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            text-decoration: none;
            margin-top: 10px;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #6d4c41;
        }
    </style>
</head>
<body>
<h1>A user with the same name already exists</h1>
<form action="db-servlet" method="POST">
    <input type="hidden" name="command" value="back"/>
    <input type="submit" value="Back"/>
</form>
</body>
</html>
