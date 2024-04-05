<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            margin-top: 20px;
            text-align: center;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .make-order-btn {
            position: absolute;
            top: 10px;
            left: 10px;
            background-color: #008CBA;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .logout-btn {
            position: absolute;
            bottom: 10px;
            right: 10px;
            background-color: #f44336;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .payment-methods-btn {
            position: absolute;
            top: 60px;
            left: 10px; /* Изменено с right на left */
            background-color: #FFA500;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        hr {
            display: none;
        }
    </style>
</head>
<body>
<button class="make-order-btn" onclick="location.href='order-form.html'">Make Order</button>
<button class="payment-methods-btn" onclick="location.href='payment-methods.html'">Payment Methods</button>
<form action="db-servlet">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" class="logout-btn" value="logOut"/>
</form>
</body>
</html>
