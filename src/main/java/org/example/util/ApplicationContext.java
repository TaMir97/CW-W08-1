package org.example.util;

import org.example.repository.implementation.BrandRepo;
import org.example.repository.implementation.CategoryRepo;
import org.example.repository.implementation.ProductRepo;
import org.example.repository.implementation.UserRepo;
import org.example.service.BrandService;
import org.example.service.CategoryService;
import org.example.service.ProductService;
import org.example.service.UserService;

public class ApplicationContext {

    private static final UserRepo userRepo;
    private static final UserService userService;
    private static final CategoryRepo categoryRepo;
    private static final CategoryService categoryService;
    private static final BrandRepo brandRepo;
    private static final BrandService brandService;
    private static final ProductRepo productRepo;
    private static final ProductService productService;

    static {
        userRepo = new UserRepo();
        userService = new UserService();
        categoryRepo = new CategoryRepo();
        categoryService = new CategoryService();
        brandRepo = new BrandRepo();
        brandService = new BrandService();
        productRepo = new ProductRepo();
        productService = new ProductService();
    }

    public static UserRepo getUserRepo() {
        return userRepo;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static CategoryRepo getCategoryRepo() {
        return categoryRepo;
    }

    public static CategoryService getCategoryService() {
        return categoryService;
    }

    public static BrandRepo getBrandRepo() {
        return brandRepo;
    }

    public static BrandService getBrandService() {
        return brandService;
    }

    public static ProductRepo getProductRepo() {
        return productRepo;
    }

    public static ProductService getProductService() {
        return productService;
    }


}
