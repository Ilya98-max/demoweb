package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.DaoException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.dao.impl.OrderDaoImpl;
import com.example.demo.dao.impl.UserDaoImpl;

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
        session.setAttribute("user_id", null);
        try {
            request.getSession().removeAttribute("login_msg");
            if (userService.authenticate(login, password)) {

                Integer userId = userService.getUserIdByLogin(login);
                session.setAttribute("user_id", userId);

                if (userService.isAdmin(login)) {

                    List<User> allUsers = UserDaoImpl.getInstance().findAll();
                    request.getSession().setAttribute("users", allUsers);

                    List<Order> allOrders = OrderDaoImpl.getInstance().findAll();
                    request.getSession().setAttribute("orders", allOrders);

                    page = "pages/user_data.jsp";
                } else {
                    page = "pages/main.jsp";
                }
            } else {

                request.getSession().setAttribute("login_msg", "Incorrect login or pass");
                page = "pages/other-page.jsp";
            }

            session.setAttribute("current_page", page);
        } catch (ServiceException | DaoException e) {
            throw new CommandException(e);
        }

        return page;
    }
}
