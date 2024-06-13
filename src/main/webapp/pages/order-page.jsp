<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding: 20px;
        }
        .menu {
            width: 45%;
            padding-right: 20px;
        }
        .order-form {
            width: 45%;
        }
        form {
            background-color: #f2f2f2;
            padding: 20px;
            border-radius: 5px;
        }
        h2 {
            margin-top: 0;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"] {
            width: calc(100% - 16px);
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="menu">
        <h2>Coffee Menu</h2>
        <ul>
            <li>Latte - $3.50</li>
            <li>Cappuccino - $3.00</li>
            <li>Cocoa - $4.00</li>
            <li>Matcha - $4.50</li>
            <li>Raf - $3.50</li>
        </ul>
        <h2>Dessert Menu</h2>
        <ul>
            <li>Doughnuts - $2.00</li>
            <li>Cheesecake - $4.50</li>
            <li>Viennese Waffles - $5.00</li>
            <li>Brownie - $3.00</li>
            <li>Croissant - $2.50</li>
        </ul>
    </div>
    <div class="order-form">
        <form action="db-servlet" method="POST">
            <h2>Place Your Order</h2>
            <input type="hidden" name="command" value="place_order"/>
            <label for="coffee_type">Coffee Type:</label><br>
            <input type="text" id="coffee_type" name="coffee_type" placeholder="Enter Coffee Type"><br>
            <label for="coffee_quantity">Coffee Quantity:</label><br>
            <input type="number" id="coffee_quantity" name="coffee_quantity" value="1" min="1" placeholder="Enter Quantity"><br>
            <label for="dessert_type">Dessert Type:</label><br>
            <input type="text" id="dessert_type" name="dessert_type" placeholder="Enter Dessert Type"><br>
            <label for="dessert_quantity">Dessert Quantity:</label><br>
            <input type="number" id="dessert_quantity" name="dessert_quantity" value="1" min="1" placeholder="Enter Quantity"><br>
            <input type="submit" name="sub" value="Place Order">
            </form>
    </div>
</div>
</body>
</html>








