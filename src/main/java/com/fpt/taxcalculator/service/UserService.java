package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.dataaccess.UserRepository;
import com.fpt.taxcalculator.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Qualifier("standardRate")
    double taxStandardRate;

    @Qualifier("above30Rate")
    double taxAbove30RateRate;

    @Qualifier("above50Rate")
    double taxAbove50RateRate;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() throws IOException {
        return userRepository.findAll();
    }
}
