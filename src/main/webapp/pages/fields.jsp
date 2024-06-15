<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fields</title>
    <style>
        body {
            background-color: #e8e6e3;
            color: #3e2723;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        h1 {
            font-size: 28px;
            text-align: center;
            color: #3e2723;
            margin-bottom: 20px;
        }
        form {
            margin-top: 20px;
            text-align: center;
        }
        input[type="submit"] {
            background-color: #795548;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #5d4037;
        }
        a {
            color: #8e3e13;
            text-decoration: none;
            font-weight: bold;
            display: inline-block;
            margin-top: 20px;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>You have not filled in any fields</h1>
<h1>To add a user, you must fill in all fields</h1>
<form action="db-servlet" method="POST">
    <input type="hidden" name="command" value="back"/>
    <input type="submit" value="Back"/>
</form>
</body>
</html>
