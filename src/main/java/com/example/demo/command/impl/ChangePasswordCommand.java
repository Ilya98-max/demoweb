package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;

public class ChangePasswordCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException, ServiceException {
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");

        if (username == null || username.isEmpty() || newPassword == null || newPassword.isEmpty()) {
            return "pages/fields.jsp";
        }


        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());


        boolean passwordChanged = UserServiceImpl.getInstance().changePasswordByUsername(username, hashedPassword);

        if (!passwordChanged) {
            return "pages/password.jsp";
        } else {
            return "index.jsp";
        }
    }
}
