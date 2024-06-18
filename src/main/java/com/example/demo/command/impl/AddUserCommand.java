package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.entity.User;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.MessagingException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;
import java.util.UUID;


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
                } catch (IOException e) {
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


            String verificationCode = UUID.randomUUID().toString().substring(0, 6);
            request.getSession().setAttribute("verification_code", verificationCode);

            try {

                this.sendVerificationCodeByEmail(email, verificationCode);
            } catch (MessagingException e) {
                throw new CommandException("Error sending verification code by email", e);
            }

            return "pages/verify.jsp";
        } else {
            return "pages/account.jsp";
        }
    }

    private static final String EMAIL = "esde.ilya@gmail.com";
    private static final String APP_PASSWORD = "bqzh rgaf bnna oner";

    private void sendVerificationCodeByEmail(String recipientEmail, String code) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, APP_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Verification Code");
            message.setText("Your verification code is: " + code);

            Transport.send(message);
            System.out.println("Email sent successfully...");

        } catch (AddressException e) {
            e.printStackTrace();
            throw new MessagingException("Error sending email", e);
        } catch (javax.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
