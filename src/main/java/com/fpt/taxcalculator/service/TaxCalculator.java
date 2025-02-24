package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TaxCalculator {
    private final UserService userService;
    private final TaxService taxService;

    public TaxCalculator(UserService userService,
                         TaxService taxService) {
        this.userService = userService;
        this.taxService = taxService;
    }

    public double calculate(Long userId) throws IOException {
        User user = userService.findById(userId);
        double income = user.getIncome();

        if (income > 30 && income <= 50) {
            return income * taxService.findByLevel("level 2").getRate();
        }

        if (income > 50) {
            return income * taxService.findByLevel("level 3").getRate();
        }

        return income * taxService.findByLevel("level 1").getRate();
    }
}
