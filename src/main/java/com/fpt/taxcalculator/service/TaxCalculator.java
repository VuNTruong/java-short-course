package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.dataaccess.UserRepository;
import com.fpt.taxcalculator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TaxCalculator {
    @Autowired
    @Qualifier("standardRate")
    double taxStandardRate;

    @Autowired
    @Qualifier("above30Rate")
    double taxAbove30RateRate;

    @Autowired
    @Qualifier("above50Rate")
    double taxAbove50RateRate;

    private final UserRepository userRepository;

    public TaxCalculator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public double calculate(Long userId) throws IOException {
        User user = userRepository.findByUserId(userId);
        double income = user.getIncome();

        if (income > 30 && income <= 50) {
            return income * taxAbove30RateRate;
        }

        if (income > 50) {
            return income * taxAbove50RateRate;
        }

        return income * taxStandardRate;
    }
}
