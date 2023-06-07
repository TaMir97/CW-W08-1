package org.example.repository.implementation;

import org.example.connection.DBConnection;
import org.example.entity.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepo {
    private final Connection connection;

    public ProductRepo(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(Product product) {
        final String QUERY = "insert into product (product_name, created_date, category_id, brand_id)" +
                " values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDate(2, new Date(product.getCreatedDate().getTime()));
            preparedStatement.setInt(3, product.getCategoryID());
            preparedStatement.setInt(4, product.getBrandID());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProduct(Product product) {
        try {
            final String QUERY = "UPDATE product SET product_name = ?, category_id = ?, brand_id = ? WHERE product_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getCategoryID());
            preparedStatement.setInt(3, product.getBrandID());
            preparedStatement.setInt(4, product.getProductID());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        try {

            final String QUERY = "DELETE FROM product WHERE product_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, productId);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

