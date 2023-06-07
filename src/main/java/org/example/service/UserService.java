package org.example.service;

import org.example.entity.User;
import org.example.repository.implementation.UserRepo;
import org.example.util.Validations;

public class UserService {
    UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        if (!userRepository.isExist(user.getUsername())) {
            if (Validations.validPassword(user.getPassword()) && Validations.validEmail(user.getEmail())) {
                userRepository.signUp(user);
            } else {
                if (!Validations.validPassword(user.getPassword())) {
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
