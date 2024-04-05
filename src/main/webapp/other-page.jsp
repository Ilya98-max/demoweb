<!DOCTYPE html>
<html>
<head>
    <title>Other Page</title>
    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            color: #333;
            margin: 0;
            padding: 0;
        }


        p {
            margin-top: 50px;
            text-align: center;
        }


        form {
            text-align: center;
        }


        input[type="submit"] {
            background-color: #ff6f61;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<p>${login_msg}</p>
<form action="db-servlet">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="logOut"/>
</form>
</body>
</html>
