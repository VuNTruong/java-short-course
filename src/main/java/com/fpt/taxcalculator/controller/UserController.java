package com.fpt.taxcalculator.controller;

import com.fpt.taxcalculator.model.User;
import com.fpt.taxcalculator.service.TaxCalculator;
import com.fpt.taxcalculator.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final TaxCalculator taxCalculator;

    public UserController(UserService userService,
                          TaxCalculator taxCalculator) {
        this.userService = userService;
        this.taxCalculator = taxCalculator;
    }

    @GetMapping
    public List<User> callGetUser() throws IOException {
        return userService.getUsers();
    }

    @GetMapping("tax/calculate/{userId}")
    public double calculateTax(@PathVariable Long userId) throws IOException {
        return taxCalculator.calculate(userId);
    }
}
