package org.example.repository.implementation;

import org.example.connection.DBConnection;
import org.example.entity.Brand;
import org.example.repository.Repository;

import java.sql.*;

public class BrandRepo implements Repository {
    public void addBrand(Brand brand) {
        Connection connection = DBConnection.getConnection();
        final String QUERY = "insert into brand (brand_name, website, description)" +
                " values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, brand.getBrandName());
            preparedStatement.setString(2, brand.getWebsite());
            preparedStatement.setString(3, brand.getDescription());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBrand(Brand newbrand) {
        try {
            Connection connection = DBConnection.getConnection();
            final String QUERY = "UPDATE brand SET brand_name = ?, website = ?, description = ? WHERE brand_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, newbrand.getBrandName());
            preparedStatement.setString(2, newbrand.getWebsite());
            preparedStatement.setString(3, newbrand.getDescription());
            preparedStatement.setInt(4, newbrand.getBrandID());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBrand(int brandId) {
        try {
            Connection connection = DBConnection.getConnection();
            final String QUERY = "DELETE FROM brand WHERE brand_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, brandId);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Brand[] loadAllBrand() {
        Brand[] brand = new Brand[recordCounter()];
        try {
            final String QUERY = "SELECT * FROM brand";
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet rs = preparedStatement.executeQuery();

            int counter = 0;
            while (rs.next()) {
                brand[counter].setBrandID(rs.getInt(1));
                brand[counter].setBrandName(rs.getString(2));
                brand[counter].setWebsite(rs.getString(3));
                brand[counter].setDescription(rs.getString(4));
                counter++;
            }
            preparedStatement.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }

    @Override
    public int recordCounter() {
        int count;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT count(*) FROM brand";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
