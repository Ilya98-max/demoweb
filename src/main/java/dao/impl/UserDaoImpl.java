package dao.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.DaoException;
import com.example.demo.pool.ConnectionPool;
import dao.BaseDao;
import dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    private static final String SELECT_LOGIN_PASSWORD = "SELECT password FROM phone_book  WHERE last_name = ?";

    private static final String INSERT_USER = "INSERT INTO phone_book (phone_number, last_name, password) VALUES (?, ?, ?)";

    private static final String SELECT_USER_BY_LAST_NAME = "SELECT phone_number, last_name, password FROM phone_book WHERE last_name = ?";

    private static final String SELECT_ALL_USERS = "SELECT phone_number, last_name, password FROM phone_book";

    private static final String SELECT_ROLE_BY_LAST_NAME = "SELECT role FROM phone_book WHERE last_name = ?";




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
            statement.setString(3, user.getPassword());

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
                        resultSet.getString("password")
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
                match = password.equals(passFromDB);
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
                        resultSet.getString("password")
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



}
