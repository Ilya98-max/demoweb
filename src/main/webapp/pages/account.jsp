<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Not Added</title>
    <style>
        body {
            font-family: 'Georgia', serif;
            background-color: #3e2723;
            color: #efebe9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .message-container {
            text-align: center;
            max-width: 80%;
            font-size: 24px;
            line-height: 1.6;
            background-color: #5d4037;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.5);
        }
        .message-container p {
            margin-bottom: 20px;
        }
        .go-back-link {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #ffe0b2;
            font-size: 18px;
            padding: 10px 20px;
            border: 1px solid #ffe0b2;
            border-radius: 5px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }
        .go-back-link:hover {
            background-color: #ffe0b2;
            color: #3e2723;
        }
    </style>
</head>
<body>
<div class="message-container">
    <p>User not added</p>
    <p>And add this <a href="../index.jsp" class="go-back-link">Go back to homepage</a></p>
</div>
</body>
</html>
