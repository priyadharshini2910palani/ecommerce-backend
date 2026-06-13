package com.priya.ecom_proj.controller;

import com.priya.ecom_proj.model.User;
import com.priya.ecom_proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.priya.ecom_proj.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){

        System.out.println("EMAIL = " + user.getEmail());
        System.out.println("PASSWORD = " + user.getPassword());

        User validUser =
                service.login(user.getEmail(), user.getPassword());

        if(validUser != null){
            return jwtService.generateToken(user.getEmail());
        }

        return "Invalid Email or Password";
    }
}