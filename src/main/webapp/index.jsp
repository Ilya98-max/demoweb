<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Coffee House</title>
  <style>
    body {
      font-family: 'Georgia', serif;
      margin: 0;
      padding: 0;
      background-color: #fdf5e6;
      color: #3e2723;
    }
    header {
      background-color: #6f4e37;
      color: #fff;
      text-align: center;
      padding: 30px 0;
      margin-bottom: 20px;
    }
    h1 {
      font-size: 2.5em;
      margin: 0;
    }
    h2 {
      margin: 0;
      padding: 10px 0;
      text-align: center;
      font-size: 1.5em;
    }
    a {
      display: block;
      text-decoration: none;
      color: #fff;
      margin-bottom: 15px;
      padding: 15px;
      border-radius: 8px;
      background-color: #8d6e63;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      transition: background-color 0.3s, transform 0.3s;
      font-weight: bold;
    }
    a:hover {
      background-color: #a1887f;
      transform: scale(1.05);
    }
    main {
      max-width: 700px;
      margin: 0 auto;
      padding: 30px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    .form-link {
      text-align: center;
    }
    .form-link a {
      margin: 10px;
    }
  </style>
</head>
<body>
<header>
  <h1>Coffee House</h1>
</header>
<main>
  <div class="form-link">
    <h2><a href="login-form.html">Login Form</a></h2>
    <h2><a href="add-user-form.html">Add User Form</a></h2>
    <h2><a href="delete-user-form.html">Delete User Form</a></h2>
    <h2><a href="change-password-form.html">Change Password Form</a></h2>
  </div>
</main>
</body>
</html>
