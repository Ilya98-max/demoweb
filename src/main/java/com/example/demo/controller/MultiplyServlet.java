package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "multiplyServlet", value = "/multiply-servlet")
public class MultiplyServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(MultiplyServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String param = request.getParameter("digit");
        int digit = Integer.parseInt(param);
        int result = digit * 2;
        logger.info("Result of multiplication " + digit + " is " + result);

         request.setAttribute("result", result);
         RequestDispatcher dispatcher = request.getRequestDispatcher("pages/result.jsp");
        try {
         dispatcher.forward(request, response);
        } catch (ServletException e) {
        logger.error("Error while forwarding request", e);
        }
    }
}