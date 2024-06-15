<!DOCTYPE html>
<html>
<head>
    <title>Other Page</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #d7c4b2;
            color: #4a4a4a;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .content {
            text-align: center;
            background-color: #ffffff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
            color: #4a4a4a;
        }

        p {
            margin-top: 20px;
        }

        form {
            margin-top: 20px;
        }

        input[type="submit"] {
            background-color: #8d6e63;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #6f4e37;
        }
    </style>
</head>
<body>
<div class="content">
    <p>${login_msg}</p>
    <form action="db-servlet">
        <input type="hidden" name="command" value="logout"/>
        <input type="submit" value="Logout"/>
    </form>
</div>
</body>
</html>
