package com.example.demo.command.impl;
import com.example.demo.command.Command;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.ServiceException;
import javax.servlet.http.HttpServletRequest;

public class VerifyCodeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ServiceException {
        String enteredCode = request.getParameter("code");
        String verificationCode = (String) request.getSession().getAttribute("verification_code");

        if (verificationCode != null && verificationCode.equals(enteredCode)) {

            return "successful.jsp";
        } else {

            return "verify.jsp";
        }
    }
}
