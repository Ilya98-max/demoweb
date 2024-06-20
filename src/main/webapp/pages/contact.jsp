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
        .map-container {
            margin-bottom: 20px;
            width: 100%;
            height: 400px; /* Adjust height as needed */
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
    <div class="map-container">
        <iframe
                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3153.086251906336!2d-122.42157788468137!3d37.77492977975988!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8085809c5e28f5e9%3A0xd9c795f3ff2dd65e!2s123%20Coffee%20Ln%2C%20San%20Francisco%2C%20CA%2094102%2C%20USA!5e0!3m2!1sen!2sus!4v1595193635178!5m2!1sen!2sus"
                width="100%" height="100%" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0">
        </iframe>
    </div>
    <a class="back-link" href="main.jsp">Back to Main Page</a>
</div>
</body>
</html>
