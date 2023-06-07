package org.example.util;

import org.example.connection.DBConnection;
import org.example.repository.implementation.BrandRepo;
import org.example.repository.implementation.CategoryRepo;
import org.example.repository.implementation.ProductRepo;
import org.example.repository.implementation.UserRepo;
import org.example.service.BrandService;
import org.example.service.CategoryService;
import org.example.service.ProductService;
import org.example.service.UserService;

import java.sql.Connection;

public class ApplicationContext {

    private static Connection connection;
    private static UserRepo userRepo;
    private static UserService userService;
    private static CategoryRepo categoryRepo;
    private static CategoryService categoryService;
    private static BrandRepo brandRepo;
    private static BrandService brandService;
    private static ProductRepo productRepo;
    private static ProductService productService;

    static {
        connection = DBConnection.getConnection();
        userRepo = new UserRepo(connection);
        userService = new UserService(userRepo);
        categoryRepo = new CategoryRepo(connection);
        categoryService = new CategoryService(categoryRepo);
        brandRepo = new BrandRepo(connection);
        brandService = new BrandService(brandRepo);
        productRepo = new ProductRepo(connection);
        productService = new ProductService(productRepo);
    }



    public static UserService getUserService() {
        return userService;
    }

    public static CategoryService getCategoryService() {
        return categoryService;
    }

    public static BrandService getBrandService() {
        return brandService;
    }

    public static ProductService getProductService() {
        return productService;
    }


}
