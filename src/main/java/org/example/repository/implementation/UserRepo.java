package org.example.repository.implementation;

import org.example.connection.DBConnection;
import org.example.entity.User;
import org.example.repository.Repository;

import java.sql.*;
import java.util.Random;

public class UserRepo  implements Repository {
    Random random = new Random();
    int records = recordCounter();

    public void signUp(User user){
        Connection connection = DBConnection.getConnection();
        final String QUERY = "insert into users (user_id, name, user_name, password, email)" +
                " values (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            user.setUserID(idGenerator());
            preparedStatement.setInt(1,user.getUserID());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());

            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(String username, String password){
        Connection connection = DBConnection.getConnection();
        User user = new User();
        final String QUERY = "select user_name,password from users where user_name = ? and password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet != null){
                while (resultSet.next() ){
                    user.setUserID(resultSet.getInt(1));
                    user.setName(resultSet.getString(2));
                    user.setUsername(resultSet.getString(3));
                    user.setPassword(resultSet.getString(4));
                    user.setEmail(resultSet.getString(5));
                }
                preparedStatement.close();
                resultSet.close();

                return true;
            } else {
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isExist(String username){
        Connection connection = DBConnection.getConnection();
        final String QUERY = "select user_name from users where user_name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet != null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int[] loadAll() {

        final String QUERY = "select user_id from users";
        int[] IDs = new int[records];
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            int counter = 0;
            while (resultSet.next()) {
                IDs[counter] = resultSet.getInt(1);
                counter++;
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return IDs;
    }
    @Override
    public int recordCounter() {
        int count;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "select count(*) from users";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return count;
    }
    @Override
    public boolean isUnique(int newID) {
        int[] IDs = loadAll();
        boolean isUnique = true;

        for(int ID: IDs){
            if (newID == ID) {
                isUnique = false;
                break;
            }
        }

        return isUnique;
    }
    @Override
    public int idGenerator(){
        int generatedID = random.nextInt(1, 10000);
        while (!isUnique(generatedID)){
            generatedID = random.nextInt(1, 10000);
        }
        return generatedID;
    }
}
