package com.example.demo.controller;

import com.example.demo.command.Command;
import com.example.demo.command.CommandType;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.ServiceException;
import com.example.demo.pool.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dbServlet", urlPatterns = {"/db-servlet", "/pages/db-servlet"})
@MultipartConfig
public class DBServlet extends HttpServlet {

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String commandStr = request.getParameter("command");
        Command command;
        try {
            command = CommandType.define(commandStr, request.getLocale());
            String page = command.execute(request);

            if (request.getMethod().equalsIgnoreCase("POST")) {
                response.sendRedirect(page);
            } else {
                request.getRequestDispatcher(page).forward(request, response);
            }
        } catch (CommandException e) {
            request.setAttribute("error_msg", e.getCause());
            request.getRequestDispatcher("/pages/error/error_500.jsp").forward(request, response);
        } catch (ServiceException e) {
            throw new ServletException(e);
        }
    }

    public void destroy() {
        ConnectionPool.getInstance().destroyPool();
    }
}
