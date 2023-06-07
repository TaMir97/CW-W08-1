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

    private static final Connection connection;

    private static final UserRepo userRepo;
    private static final UserService userService;
    private static final CategoryRepo categoryRepo;
    private static final CategoryService categoryService;
    private static final BrandRepo brandRepo;
    private static final BrandService brandService;
    private static final ProductRepo productRepo;
    private static final ProductService productService;

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
