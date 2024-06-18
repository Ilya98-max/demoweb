package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.ServiceException;

import java.util.List;

public interface UserService {

     boolean authenticate (String login , String password ) throws ServiceException;

     boolean add(User user);

     User getUserByLastName(String lastName) throws ServiceException;

     List<User> findAll() throws ServiceException;

     boolean isAdmin(String login) throws ServiceException;

     boolean deleteAccountByUsername(String username) throws ServiceException;

     boolean changePasswordByUsername(String username, String newPassword) throws ServiceException;

     Integer getUserIdByLogin(String login) throws ServiceException;


}

