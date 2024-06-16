<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="order.page.title"/></title>
    <style>
        body {
            font-family: 'Georgia', serif;
            background-color: #3e2723;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #efebe9;
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
        .message-container h2 {
            font-size: 36px;
            margin-bottom: 20px;
            color: #efebe9;
        }
        .actions-info {
            margin-top: 20px;
            font-size: 18px;
            color: #efebe9;
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
            color: #ffe0b2;
            text-decoration: none;
            transition: color 0.3s ease;
        }
        .actions-info ul li a:hover {
            color: #ffcc80;
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
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="prop.text" var="en"/>
<fmt:setBundle basename="prop.text_ru" var="ru"/>
<div class="container">
    <div class="message">
        <h2><fmt:message key="order.ready.title" bundle="${language eq 'ru' ? ru : en}"/></h2>
        <p><fmt:message key="order.ready.message1" bundle="${language eq 'ru' ? ru : en}"/></p>
        <p><fmt:message key="order.ready.message2" bundle="${language eq 'ru' ? ru : en}"/></p>
        <div class="actions-info">
            <p><fmt:message key="order.message.actions" bundle="${language eq 'ru' ? ru : en}"/></p>
            <ul>
                <li><fmt:message key="order.action.contact" bundle="${language eq 'ru' ? ru : en}"/></li>
                <li><fmt:message key="order.action.visit" bundle="${language eq 'ru' ? ru : en}"/></li>
            </ul>
        </div>
    </div>
</div>
<a href="order-page.jsp" class="go-back-link"><fmt:message key="order.page.button" bundle="${language eq 'ru' ? ru : en}"/></a>
</body>
</html>
