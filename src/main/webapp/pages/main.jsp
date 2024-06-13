<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
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
        .upload-form {
            position: absolute;
            bottom: 10px;
            left: 10px;
        }
        .upload-btn {
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            background-color: #d9534f;
            color: white;
            cursor: pointer;
        }
        #current-time {
            font-size: 18px;
            font-weight: bold;
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<div style="text-align: center;">
    <p style="font-size: 28px;">The best coffee in town. Fresh and delicious pastries</p>
</div>

<h1>Menu Page</h1>
<div>
    <button class="menu-btn" onclick="redirectToOrderPage()">Menu Page</button>
</div>

<form action="db-servlet">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" class="logout-btn" value="Logout"/>
</form>

<form class="upload-form" action="db-servlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="command" value="upload_photo"/>
    <input type="file" name="photo" accept="image/*"/>
    <input type="submit" class="upload-btn" value="Upload Photo"/>
</form>

<script>
    function redirectToOrderPage() {
        window.location.href = 'pages/order-page.jsp';
    }
</script>
</body>
</html>





