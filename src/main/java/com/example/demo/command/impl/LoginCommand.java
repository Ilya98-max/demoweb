package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.entity.User;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.DaoException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import dao.impl.UserDaoImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        UserService userService = UserServiceImpl.getInstance();
        String page;
        HttpSession session = request.getSession();
        try {
            if (userService.authenticate(login, password)) {
                request.setAttribute("user", login);
                session.setAttribute("user_name", login);
                if (userService.isAdmin(login)) {
                    List<User> allUsers;
                    try {
                        allUsers = UserDaoImpl.getInstance().findAll();
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("users", allUsers);
                    page = "pages/user_data.jsp";
                } else {
                    page = "pages/main.jsp";
                }
            } else {
                request.setAttribute("login_msg", "incorrect login or pass");
                page = "other-page.jsp";
            }
            session.setAttribute("current_page", page);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return page;
    }
}
