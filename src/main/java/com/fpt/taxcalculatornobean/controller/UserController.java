package com.fpt.taxcalculatornobean.controller;

import com.fpt.taxcalculatornobean.model.User;
import com.fpt.taxcalculatornobean.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/start/users")
public class UserController {
    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @GetMapping
    public List<User> getAllUsers() throws IOException {
        return userService.getUsers();
    }
}
