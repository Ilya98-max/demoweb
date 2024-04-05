<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Successful</title>
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
    </style>
</head>
<body>

<h1>Users Successfully Added</h1>

<form action="db-servlet" method="GET">
    <input type="hidden" name="command" value="back"/>
    <input type="submit" value="Back"/>
</form>

</body>
</html>
