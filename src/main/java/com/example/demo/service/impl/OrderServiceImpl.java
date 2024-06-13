package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.exception.DaoException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.OrderService;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;

import java.util.List;

;

public class OrderServiceImpl implements OrderService {
    private static final OrderServiceImpl instance = new OrderServiceImpl();

    private OrderServiceImpl() {
    }

    public static OrderServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean addOrder(Order order) throws ServiceException {
        OrderDao orderDao = OrderDaoImpl.getInstance();
        try {
            return orderDao.insert(order);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> findAll() throws ServiceException {
        OrderDao orderDao = OrderDaoImpl.getInstance();
        try {
            return orderDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}




