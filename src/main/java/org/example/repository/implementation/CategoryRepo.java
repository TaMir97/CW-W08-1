package org.example.repository.implementation;

import org.example.connection.DBConnection;
import org.example.entity.Category;
import org.example.repository.Repository;

import java.sql.*;

public class CategoryRepo implements Repository {
    public void addCategory(Category category) {
        Connection connection = DBConnection.getConnection();
        final String QUERY = "insert into category (category_name, description)" +
                " values (?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setString(2, category.getDescription());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCategory(Category category) {
        try {
            Connection connection = DBConnection.getConnection();
            final String QUERY = "UPDATE category SET category_name = ?, description = ? WHERE category_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setInt(3, category.getCategoryID());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(int categoryId) {
        try {
            Connection connection = DBConnection.getConnection();
            final String QUERY = "DELETE FROM category WHERE category_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, categoryId);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Category [] loadAllCategory() {
        Category [] category = new Category [recordCounter()];
        try {
            final String QUERY = "SELECT * FROM category";
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet rs = preparedStatement.executeQuery();

            int counter = 0;
            while (rs.next()) {
                category [counter].setCategoryID(rs.getInt(1));
                category [counter].setCategoryName(rs.getString(2));
                category [counter].setDescription(rs.getString(3));
                counter++;
            }
            preparedStatement.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public int recordCounter() {
        int count;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT count(*) FROM category";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
