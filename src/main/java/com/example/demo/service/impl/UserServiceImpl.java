package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.DaoException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.UserService;
import dao.UserDao;
import dao.impl.UserDaoImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    private  static final UserServiceImpl instance = new UserServiceImpl();

    public UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }


    @Override
    public boolean authenticate(String login, String password) throws ServiceException {
        // validate login , pass + md5
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = false;
        try {
            match = userDao.authenticate(login , password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        return match;
    }

    //todo
    @Override
    public boolean add(User user) {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean added = userDao.insert(user);
        return added;
    }


    @Override
    public User getUserByLastName(String lastName) throws ServiceException {
        UserDao userDao = UserDaoImpl.getInstance();
        try {
            return userDao.getUserByLastName(lastName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public List<User> findAll() throws ServiceException {
        UserDao userDao = UserDaoImpl.getInstance();
        try {
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean isAdmin(String login) throws ServiceException {
        UserDao userDao = UserDaoImpl.getInstance();
        boolean isAdmin = false;
        try {
            isAdmin = userDao.isAdmin(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isAdmin;
    }
}