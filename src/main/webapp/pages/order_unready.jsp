<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="error.page.title"/></title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #795548;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #fff;
        }
        .message-container {
            text-align: center;
            max-width: 80%;
            font-size: 24px;
            line-height: 1.6;
            background-color: #8d6e63;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.5);
        }
        .message-container h2 {
            font-size: 36px;
            margin-bottom: 20px;
            color: #fff;
        }
        .actions-info {
            margin-top: 20px;
            font-size: 18px;
            color: #fff;
        }
        .actions-info p {
            margin-bottom: 10px;
        }
        .actions-info ul {
            list-style-type: none;
            padding: 0;
            margin-top: 10px;
        }
        .actions-info ul li {
            margin-bottom: 10px;
        }
        .actions-info ul li a {
            color: #ff9800;
            text-decoration: none;
            transition: color 0.3s ease;
        }
        .actions-info ul li a:hover {
            color: #fb8c00;
        }
    </style>
</head>
<body>

<c:set var="language" value="${param.language}" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="prop.text" var="en"/>
<fmt:setBundle basename="prop.text_ru" var="ru"/>

<div class="message-container">
    <h2><fmt:message key="error.message.title" bundle="${language eq 'ru' ? ru : en}"/></h2>
    <p><fmt:message key="error.message.description" bundle="${language eq 'ru' ? ru : en}"/></p>
    <div class="actions-info">
        <p><fmt:message key="error.message.promotions" bundle="${language eq 'ru' ? ru : en}"/></p>
        <ul>
            <li><fmt:message key="error.promotion.monday" bundle="${language eq 'ru' ? ru : en}"/></li>
            <li><fmt:message key="error.promotion.summerBlend" bundle="${language eq 'ru' ? ru : en}"/></li>
        </ul>
        <p><fmt:message key="error.message.coffeeOptions" bundle="${language eq 'ru' ? ru : en}"/></p>
        <ul>
            <li><fmt:message key="error.coffee.affogato" bundle="${language eq 'ru' ? ru : en}"/></li>
            <li><fmt:message key="error.coffee.flatWhite" bundle="${language eq 'ru' ? ru : en}"/></li>
            <li><fmt:message key="error.coffee.cappuccino" bundle="${language eq 'ru' ? ru : en}"/></li>
        </ul>
    </div>
</div>
</body>
</html>
