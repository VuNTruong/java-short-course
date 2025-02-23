package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.model.User;
import com.fpt.taxcalculator.utils.UserFetching;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    private final UserFetching userFetching;

    @Qualifier("standardRate")
    double taxStandardRate;

    @Qualifier("above30Rate")
    double taxAbove30RateRate;

    @Qualifier("above50Rate")
    double taxAbove50RateRate;

    public UserService(UserFetching userFetching) {
        this.userFetching = userFetching;
    }

    public List<User> getUsers() throws IOException {
        return userFetching.findAll();
    }
}
