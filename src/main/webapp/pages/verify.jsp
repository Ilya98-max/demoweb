<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verification Code</title>
    <style>
        body {
            background-color: #f7f3e9;
            color: #4b3832;
            font-family: 'Courier New', Courier, monospace;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #d8c3a5;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
        }
        input[type="text"], input[type="submit"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #8d6e63;
            border-radius: 4px;
        }
        input[type="text"] {
            background-color: #efebe9;
        }
        input[type="submit"] {
            background-color: #6d4c41;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #5d4037;
        }
        .coffee-cup {
            font-size: 50px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="coffee-cup">☕</div>
    <h2>Verification Code</h2>
    <form action="db-servlet" method="POST">
        <input type="hidden" name="command" value="verify_code">
        <input type="text" name="code" placeholder="Enter verification code" required>
        <input type="submit" name="sub" value="Verify Code">
    </form>
</div>
</body>
</html>










