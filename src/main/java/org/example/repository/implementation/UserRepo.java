package org.example.repository.implementation;

import org.example.connection.DBConnection;
import org.example.entity.User;

import java.sql.*;
import java.util.Random;

public class UserRepo {

    public void signUp(User user) {
        Connection connection = DBConnection.getConnection();
        final String QUERY = "insert into users (name, user_name, password, email)" +
                " values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User login(String username, String password) {
        Connection connection = DBConnection.getConnection();
        User user = new User();
        final String QUERY = "select * from users where user_name = ? and password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                user.setUserID(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setEmail(resultSet.getString(5));
            }
            preparedStatement.close();
            resultSet.close();

            return user;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isExist(String username) {
        Connection connection = DBConnection.getConnection();
        User user = new User();
        final String QUERY = "select * from users where user_name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setUserID(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setEmail(resultSet.getString(5));
            }

            return user.getUserID() != 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
