<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - The Coffee House</title>
    <style>
        body {
            background-color: #f3efe2;
            color: #4b3832;
            font-family: 'Courier New', Courier, monospace;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .header {
            background-color: #4b3832;
            color: #efebe9;
            width: 100%;
            padding: 20px 0;
            text-align: center;
        }
        .header h1 {
            margin: 0;
        }
        .container {
            padding: 20px;
            max-width: 800px;
            width: 100%;
            text-align: left;
        }
        .content-section {
            margin-bottom: 20px;
        }
        .content-section h2 {
            margin-bottom: 10px;
        }
        .content-section p {
            line-height: 1.6;
        }
        .back-link {
            margin-top: 20px;
            display: block;
            text-align: center;
            padding: 10px 20px;
            background-color: #6f4e37;
            color: #efebe9;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }
        .back-link:hover {
            background-color: #5a3d2b;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Contact Us</h1>
</div>
<div class="container">
    <div class="content-section">
        <h2>Our Location</h2>
        <p>123 Coffee Lane, Caffeine City, CO 12345</p>
    </div>
    <div class="content-section">
        <h2>Contact Information</h2>
        <p>Email: contact@coffeehouse.com</p>
        <p>Phone: (123) 456-7890</p>
    </div>
    <a class="back-link" href="main.jsp">Back to Main Page</a>
</div>
</body>
</html>
