<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verification Code</title>
</head>
<body>
<h2>Verification Code</h2>
<form action="db-servlet" method="POST">>
    <input type="hidden" name="command" value="verify_code">
    <input type="text" name="code" placeholder="Enter verification code" required>
    <input type="submit" name="sub" value="Verify Code">
</form>
</body>
</html>












