package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class UploadPhotoCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ServiceException {
        return null;
    }
}
