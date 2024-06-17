package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.exception.DaoException;
import com.example.demo.pool.ConnectionPool;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class UserDaoImpl extends BaseDao<User> implements UserDao {
    private static final String SELECT_LOGIN_PASSWORD = "SELECT password FROM users  WHERE last_name = ?";

    private static final String INSERT_USER = "INSERT INTO users (phone_number, last_name, password,email,photo) VALUES (?, ?, ?,?,?)";

    private static final String SELECT_USER_BY_LAST_NAME = "SELECT phone_number, last_name, password ,email,photo FROM users WHERE last_name = ?";

    private static final String SELECT_ALL_USERS = "SELECT phone_number, last_name, password,email,photo FROM users";

    private static final String SELECT_ROLE_BY_LAST_NAME = "SELECT role FROM users WHERE last_name = ?";

    private static final String UPDATE_PASSWORD_BY_USERNAME = "UPDATE users SET password = ? WHERE last_name = ?";

    private static final String SELECT_USER_ID_BY_LOGIN = "SELECT user_id FROM users WHERE last_name = ?";

    private static final String SQL_DELETE_USERS_AND_ORDERS_BY_LAST_NAME =
            "WITH deleted_orders AS (" +
                    "    DELETE FROM orders" +
                    "    WHERE user_id IN (" +
                    "        SELECT user_id" +
                    "        FROM users" +
                    "        WHERE last_name = ?" +
                    "    )" +
                    ")" +
                    "DELETE FROM users WHERE last_name = ?";







    private static UserDaoImpl instance = new UserDaoImpl();

    private UserDaoImpl() {

    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean insert(User user) {
        boolean added = false;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER)) {

            statement.setString(1, user.getPhoneNumber());
            statement.setString(2, user.getLastName());
            // statement.setString(3, user.getPassword());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setBytes(5,user.getPhoto());

            int rowsAffected = statement.executeUpdate();
            added = rowsAffected > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return added;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> userList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS)) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("phone_number"),
                        resultSet.getString("last_name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getBytes("photo")

                );
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all users", e);
        }
        return userList;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) throws DaoException {
        boolean match = false;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            String passFromDB;

            if (resultSet.next()) {
                passFromDB = resultSet.getString(1);
                match = BCrypt.checkpw(password, passFromDB);

            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return match;
    }



    @Override
    public User getUserByLastName(String lastName) throws DaoException {
        User user = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_LAST_NAME)) {
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getString("phone_number"),
                        resultSet.getString("last_name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getBytes("photo")
                );
            }
        } catch (SQLException e) {
            throw new DaoException("Error while getting user by last name", e);
        }
        return user;
    }


    public boolean isAdmin(String login) {
        boolean isAdmin = false;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ROLE_BY_LAST_NAME)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                if ("admin".equals(role)) {
                    isAdmin = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAdmin;
    }

    @Override
    public boolean deleteByUsername(String username) throws DaoException {
        boolean deleted = false;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(SQL_DELETE_USERS_AND_ORDERS_BY_LAST_NAME)) {

            // Установка параметров для удаления
            deleteStatement.setString(1, username);
            deleteStatement.setString(2, username );

            // Выполнение запроса на удаление
            int rowsAffected = deleteStatement.executeUpdate();

            // Проверка успешности удаления
            if (rowsAffected > 0) {
                deleted = true;
            }

        } catch (SQLException throwables) {
            throw new DaoException("Error deleting users and orders by last name", throwables);
        }

        return deleted;
    }



    public boolean changePasswordByUsername(String username, String hashedPassword) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PASSWORD_BY_USERNAME)) {

            statement.setString(1, hashedPassword);
            statement.setString(2, username);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DaoException("Error changing password for username: " + username, e);
        }
    }
    @Override
    public Integer getUserIdByLogin(String login) throws DaoException {
        Integer userId = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_ID_BY_LOGIN)) {

            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt("user_id");
            }

        } catch (SQLException e) {
            throw new DaoException("Error getting user ID by login", e);
        }

        return userId;
    }



}

