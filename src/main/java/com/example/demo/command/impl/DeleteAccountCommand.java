package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteAccountCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException, ServiceException {
        String username = request.getParameter("username");

        if (username == null || username.isEmpty()) {
            return "pages/fields.jsp";
        }

        boolean deleted = UserServiceImpl.getInstance().deleteAccountByUsername(username);

        if (!deleted) {
            return "pages/unsuccessful.jsp";
        } else {
            return "../index.jsp";
        }
    }
}
