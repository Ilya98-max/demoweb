<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fields</title>
    <style>
        body {
            background-color: #ffffff;
            color: #000000;
            font-family: Arial, sans-serif;
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
            margin-top: 20px;
            text-align: center;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>You have not filled in all fields in the form</h1>
<form action="db-servlet" method="GET">
    <input type="hidden" name="command" value="back"/>
    <input type="submit" value="Back"/>
</form>
</body>
</html>
