package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.entity.User;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class AddUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        String phoneNumber = request.getParameter("phone_number");
        String lastName = request.getParameter("last_name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        byte[] photo = new byte[0];


        try {
            Part filePart = request.getPart("photo");
            if (filePart != null && filePart.getSize() > 0) {
                try (InputStream inputStream = filePart.getInputStream()) {
                    photo = inputStream.readAllBytes();
                } catch (IOException e ) {
                    throw new CommandException("Error reading photo bytes from input stream", e);
                }
            }
        } catch (IOException | ServletException e) {
            throw new CommandException("Error retrieving photo from request", e);
        }


        if (phoneNumber == null || lastName == null || password == null || email == null ||
                phoneNumber.isEmpty() || lastName.isEmpty() || password.isEmpty() || email.isEmpty()) {
            return "pages/fields.jsp";
        }


        if (phoneNumber.length() != 11 || !phoneNumber.startsWith("+")) {
            return "/add-user-form.html";
        }

        try {

            if (UserServiceImpl.getInstance().getUserByLastName(lastName) != null) {
                return "pages/Users.jsp";
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }


        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());


        User newUser = new User(phoneNumber, lastName, hashedPassword, email, photo);


        boolean added = UserServiceImpl.getInstance().add(newUser);

        if (added) {
            Integer userId = null;
            try {
                userId = UserServiceImpl.getInstance().getUserIdByLogin(lastName);
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }


            request.getSession().setAttribute("user_id", userId);
            request.getSession().setAttribute("login", lastName);


            if (photo.length > 0) {
                String encodedPhoto = Base64.getEncoder().encodeToString(photo);
                request.getSession().setAttribute("photo", encodedPhoto);
            }

            return "pages/successful.jsp";
        } else {
            return "pages/account.jsp";
        }
    }
}
