package com.example.demo.dao.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;
import com.example.demo.exception.DaoException;
import com.example.demo.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {


    private static final String INSERT_ORDER = "INSERT INTO orders (coffee_type, coffee_quantity, dessert_type, dessert_quantity, user_id) VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_ORDERS = "SELECT coffee_type, coffee_quantity, dessert_type, dessert_quantity, user_id FROM orders";

    private static final OrderDaoImpl instance = new OrderDaoImpl();

    private OrderDaoImpl() {
    }

    public static OrderDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean insert(Order order) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ORDER)) {

            statement.setString(1, order.getCoffeeType());
            statement.setInt(2, order.getCoffeeQuantity());
            statement.setString(3, order.getDessertType());
            statement.setInt(4, order.getDessertQuantity());
            statement.setInt(5, order.getUserId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {

            throw new DaoException("Error while inserting order", e);
        }
    }

    @Override
    public List<Order> findAll() throws DaoException {
        List<Order> orderList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_ORDERS)) {

            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getString("coffee_type"),
                        resultSet.getInt("coffee_quantity"),
                        resultSet.getString("dessert_type"),
                        resultSet.getInt("dessert_quantity"),
                        resultSet.getInt("user_id")
                );
                orderList.add(order);
            }
        } catch (SQLException e) {

            throw new DaoException("Error while finding all orders", e);
        }
        return orderList;
    }
}
