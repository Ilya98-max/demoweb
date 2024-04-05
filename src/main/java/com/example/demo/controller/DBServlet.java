package com.example.demo.controller;

import com.example.demo.command.Command;
import com.example.demo.command.CommandType;
import com.example.demo.exception.CommandException;
import com.example.demo.pool.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dbServlet", urlPatterns= {"/db-servlet", "*.do"})
public class DBServlet extends HttpServlet {
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String commandStr = request.getParameter("command");
        Command command   = CommandType.define(commandStr);
        String page ;
        try {
            page = command.execute(request);
            request.getRequestDispatcher(page).forward(request,response );
           // response.sendRedirect( page);
        } catch (CommandException e) {
          //response.sendError(500);//1
            //throw new ServletException(e);//2
            request.setAttribute("error_msg",e.getCause());//3
            request.getRequestDispatcher("pages/error/error_500.jsp").forward(request,response );
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy(){
        ConnectionPool.getInstance().destroyPool();
    }
}
