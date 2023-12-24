package com.techforb.technicaltest.controllers;

import com.techforb.technicaltest.models.User;
import com.techforb.technicaltest.services.UserService;
import com.techforb.technicaltest.utils.ApiResponseUtil;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

@PostMapping("/create")
public ResponseEntity<String> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
            return ApiResponseUtil.badRequest("Invalid user data");
     }
    try {
        userService.createUser(user);
        return ApiResponseUtil.success("User created successfully");
    } catch (Exception e) {
        return ApiResponseUtil.internalServerError(e.getMessage());
    }
}
}
