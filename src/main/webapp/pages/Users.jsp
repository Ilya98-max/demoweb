<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Users</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff;
            color: #721c24;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        h1 {
            font-size: 24px;
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            text-decoration: none;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<h1>A user with the same name already exists</h1>
<form action="db-servlet" method="GET">
    <input type="hidden" name="command" value="back"/>
    <input type="submit" value="Back"/>
</form>
</body>
</html>
