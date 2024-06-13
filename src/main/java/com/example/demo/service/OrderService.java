package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.exception.ServiceException;

import java.util.List;

public interface OrderService {
    boolean addOrder(Order order) throws ServiceException;

    List<Order> findAll() throws ServiceException;
}
