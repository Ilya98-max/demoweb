package dao;

import com.example.demo.entity.User;
import com.example.demo.exception.DaoException;

import java.util.List;

public interface UserDao {
    boolean authenticate (String login , String password ) throws DaoException;

    boolean insert(User user) throws DaoException  ;


    User getUserByLastName(String lastName) throws DaoException;

    List<User> findAll() throws DaoException;

    boolean isAdmin(String login) throws DaoException;


}
