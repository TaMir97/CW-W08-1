package org.example.application;

import org.example.entity.Brand;
import org.example.entity.User;
import org.example.repository.implementation.UserRepo;
import org.example.service.BrandService;
import org.example.service.UserService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        User user = new User("Tahoora", "ta", "123@fT45", "tamir@yahoo.com");
        UserService userService = new UserService();
        userService.register(user);
        User login = userService.login("ta", "123@fT45");

        BrandService brandService = new BrandService();
        Brand brand = new Brand("newBrand","https://www.newbrand.com/","describe");
        brandService.addNewBrand(brand,login);
    }
}
