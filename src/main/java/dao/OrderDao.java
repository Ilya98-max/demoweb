package dao;

import com.example.demo.entity.Order;
import com.example.demo.exception.DaoException;

import java.util.List;

public interface OrderDao {
    boolean insert(Order order) throws DaoException;
    List<Order> findAll() throws DaoException;
}

