package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        // Получаем токен из куки
        String currentToken = null;
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sessionToken".equals(cookie.getName())) {
                    currentToken = cookie.getValue();
                    break;
                }
            }
        }

        // Получаем токен из сессии
        String sessionToken = (String) session.getAttribute("sessionToken");

        // Проверяем, является ли текущий токен тем же, что и в сессии
        boolean isRefresh = currentToken != null && currentToken.equals(sessionToken);

        if (isRefresh) {
            // Если токен совпадает с токеном в сессии
            System.out.println("Обновление страницы (F5) или кнопка 'Назад'");
        } else {
            // Если токен новый или отсутствует в сессии
            System.out.println("Новый запрос");
            // Генерируем новый токен и сохраняем его в сессии и куки
            currentToken = UUID.randomUUID().toString();
            session.setAttribute("sessionToken", currentToken);
            Cookie sessionCookie = new Cookie("sessionToken", currentToken);
            sessionCookie.setPath("/");
            httpResponse.addCookie(sessionCookie);
        }

        // Пропускаем запрос дальше по цепочке
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroyed.");
    }
}
