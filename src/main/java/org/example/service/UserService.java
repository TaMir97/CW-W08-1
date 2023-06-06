package org.example.service;

import org.example.entity.User;
import org.example.repository.implementation.UserRepo;
import org.example.util.Valid;

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

    public User login(String username, String password) {
        if (isExist(username)) {
           return userRepository.login(username,password);
        } else {
            return null;
        }
    }

    public boolean isExist(String username){
        return userRepository.isExist(username);
    }
}
