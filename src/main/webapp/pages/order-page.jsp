<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="order.page.title"/></title>
    <style>
        body {
            font-family: 'Georgia', serif;
            margin: 0;
            padding: 0;
            background-color: #fdf5e6;
            color: #3e2723;
            transition: background-color 0.3s, color 0.3s;
        }
        body.dark-theme {
            background-color: #333;
            color: #fff;
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
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s;
            margin-bottom: 20px;
        }
        form.dark-theme {
            background-color: #444;
            color: #fff;
        }
        h2 {
            margin-top: 0;
            font-size: 1.5em;
            text-align: center;
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }
        input[type="text"],
        input[type="number"] {
            width: calc(100% - 16px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 1em;
        }
        select {
            width: calc(100% - 16px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 1em;
        }
        input[type="submit"] {
            background-color: #6f4e37;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
            transition: background-color 0.3s;
            width: 100%;
            box-sizing: border-box;
        }
        input[type="submit"]:hover {
            background-color: #8d6e63;
        }
        .theme-switch {
            margin: 20px;
            background-color: #6f4e37;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
            transition: background-color 0.3s;
        }
        .theme-switch:hover {
            background-color: #8d6e63;
        }
        .username-box {
            position: fixed;
            top: 10px;
            left: 10px;
            background-color: #6f4e37;
            color: white;
            padding: 5px 10px;
            border-radius: 4px;
        }
        .menu ul {
            list-style-type: none;
            padding: 0;
        }
        .menu ul li {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }
        .menu ul li img {
            width: 100px; /* Ширина изображений */
            height: auto; /* Автоматическая высота, чтобы сохранить соотношение сторон */
            margin-right: 10px;
            border-radius: 4px;
            object-fit: cover;
        }
    </style>
    <script>
        var userName = '<%= session.getAttribute("login") %>';

        document.addEventListener('DOMContentLoaded', function() {
            var userNameElement = document.createElement('div');
            userNameElement.className = 'username-box';
            userNameElement.textContent = userName;
            document.body.appendChild(userNameElement);
        });

        function submitForm() {
            document.getElementById('languageForm').submit();
        }

        function toggleTheme() {
            document.body.classList.toggle('dark-theme');
            document.querySelectorAll('form').forEach(form => form.classList.toggle('dark-theme'));
            const isDark = document.body.classList.contains('dark-theme');
            localStorage.setItem('theme', isDark ? 'dark' : 'light');
        }

        window.onload = function() {
            const theme = localStorage.getItem('theme');
            if (theme === 'dark') {
                document.body.classList.add('dark-theme');
                document.querySelectorAll('form').forEach(form => form.classList.add('dark-theme'));
            }
        }
    </script>
</head>
<body>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="prop.text" var="en"/>
<fmt:setBundle basename="prop.text_ru" var="ru"/>
<div class="container">
    <div class="menu">
        <h2><fmt:message key="coffee.menu.title" bundle="${language eq 'ru' ? ru : en}"/></h2>
        <ul>
            <li>
                <img src="images/latte.jpg" alt="Latte" />
                <fmt:message key="coffee.menu.latte" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
            <li>
                <img src="images/cappuccino.jpg" alt="Cappuccino" />
                <fmt:message key="coffee.menu.cappuccino" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
            <li>
                <img src="images/cocoa.jpg" alt="Cocoa" />
                <fmt:message key="coffee.menu.cocoa" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
            <li>
                <img src="images/matcha.jpg" alt="Matcha" />
                <fmt:message key="coffee.menu.matcha" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
            <li>
                <img src="images/raf.jpg" alt="Raf" />
                <fmt:message key="coffee.menu.raf" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
        </ul>
        <h2><fmt:message key="dessert.menu.title" bundle="${language eq 'ru' ? ru : en}"/></h2>
        <ul>
            <li>
                <img src="images/doughnuts.jpg" alt="Doughnuts" />
                <fmt:message key="dessert.menu.doughnuts" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
            <li>
                <img src="images/cheesecake.jpg" alt="Cheesecake" />
                <fmt:message key="dessert.menu.cheesecake" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
            <li>
                <img src="images/waffles.jpg" alt="Waffles" />
                <fmt:message key="dessert.menu.waffles" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
            <li>
                <img src="images/brownie.jpg" alt="Brownie" />
                <fmt:message key="dessert.menu.brownie" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
            <li>
                <img src="images/croissant.jpg" alt="Croissant" />
                <fmt:message key="dessert.menu.croissant" bundle="${language eq 'ru' ? ru : en}"/>
            </li>
        </ul>
    </div>
    <div class="order-form">
        <form id="languageForm" action="" method="GET">
            <select id="language" name="language" onchange="submitForm()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
            </select>
        </form>
        <form action="db-servlet" method="POST">
            <input type="hidden" name="language" value="${language}"/>
            <h2><fmt:message key="place.order.title" bundle="${language eq 'ru' ? ru : en}"/></h2>
            <input type="hidden" name="command" value="<fmt:message key='place.order.command' bundle="${language eq 'ru' ? ru : en}"/>"/>
            <label for="coffee_type"><fmt:message key="coffee.type.label" bundle="${language eq 'ru' ? ru : en}"/></label><br>
            <select id="coffee_type" name="coffee_type">
                <option value="latte"><fmt:message key="coffee.menu.latte" bundle="${language eq 'ru' ? ru : en}"/></option>
                <option value="cappuccino"><fmt:message key="coffee.menu.cappuccino" bundle="${language eq 'ru' ? ru : en}"/></option>
                <option value="cocoa"><fmt:message key="coffee.menu.cocoa" bundle="${language eq 'ru' ? ru : en}"/></option>
                <option value="matcha"><fmt:message key="coffee.menu.matcha" bundle="${language eq 'ru' ? ru : en}"/></option>
                <option value="raf"><fmt:message key="coffee.menu.raf" bundle="${language eq 'ru' ? ru : en}"/></option>
            </select><br>
            <label for="coffee_quantity"><fmt:message key="coffee.quantity.label" bundle="${language eq 'ru' ? ru : en}"/></label><br>
            <input type="number" id="coffee_quantity" name="coffee_quantity" value="1" min="1" placeholder="<fmt:message key='coffee.quantity.placeholder' bundle="${language eq 'ru' ? ru : en}"/>"><br>
            <label for="dessert_type"><fmt:message key="dessert.type.label" bundle="${language eq 'ru' ? ru : en}"/></label><br>
            <select id="dessert_type" name="dessert_type">
                <option value="doughnuts"><fmt:message key="dessert.menu.doughnuts" bundle="${language eq 'ru' ? ru : en}"/></option>
                <option value="cheesecake"><fmt:message key="dessert.menu.cheesecake" bundle="${language eq 'ru' ? ru : en}"/></option>
                <option value="waffles"><fmt:message key="dessert.menu.waffles" bundle="${language eq 'ru' ? ru : en}"/></option>
                <option value="brownie"><fmt:message key="dessert.menu.brownie" bundle="${language eq 'ru' ? ru : en}"/></option>
                <option value="croissant"><fmt:message key="dessert.menu.croissant" bundle="${language eq 'ru' ? ru : en}"/></option>
            </select><br>
            <label for="dessert_quantity"><fmt:message key="dessert.quantity.label" bundle="${language eq 'ru' ? ru : en}"/></label><br>
            <input type="number" id="dessert_quantity" name="dessert_quantity" value="1" min="1" placeholder="<fmt:message key='dessert.quantity.placeholder' bundle="${language eq 'ru' ? ru : en}"/>"><br>
            <input type="submit" name="sub" value="<fmt:message key='place.order.button' bundle="${language eq 'ru' ? ru : en}"/>">
        </form>
    </div>
</div>
</body>
</html>





