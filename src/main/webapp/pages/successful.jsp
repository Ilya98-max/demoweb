<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Page</title>
    <style>
        .menu-btn {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-bottom: 10px;
            margin-left: 10px; /* Уменьшенный отступ слева */
            background-color: #f0ad4e;
            color: white;
            cursor: pointer;
        }
        .logout-btn {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-bottom: 10px;
            position: absolute;
            bottom: 10px;
            right: 10px;
            background-color: #5cb85c;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Menu Page</h1>
<div>
    <button class="menu-btn" onclick="redirectToOrderPage()">Menu Page</button>
</div>

<form action="db-servlet">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" class="logout-btn" value="Logout"/>
</form>

<script>
    function redirectToOrderPage() {
        window.location.href = 'pages/order-page.jsp';
    }
</script>
</body>
</html>
