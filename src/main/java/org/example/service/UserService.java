package org.example.service;

import org.example.entity.User;
import org.example.repository.implementation.UserRepo;
import org.example.validation.Valid;

public class UserService {
    UserRepo userRepository = new UserRepo();

    public void register(User user) {
        if (!userRepository.isExist(user.getUsername())) {
            if (Valid.validPassword(user.getPassword()) && Valid.validEmail(user.getEmail())) {
                userRepository.signUp(user);
            } else {
                if (!Valid.validPassword(user.getPassword())) {
                    System.out.println("Your password is wrong");
                } else {
                    System.out.println("Your email is wrong");
                }
            }
        } else {
            System.out.println("Please login");
        }
    }

    public void login(String username, String password) {
        if (userRepository.isExist(username)) {
            userRepository.login(username,password);
        } else {
            System.out.println("Please sign up");
        }
    }
}
