package com.fpt.taxcalculatornobean.service;

import com.fpt.taxcalculatornobean.model.User;
import com.fpt.taxcalculatornobean.repository.UserRepository;

import java.io.IOException;
import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public List<User> getUsers() throws IOException {
        return userRepository.getAllUsers();
    }
}
