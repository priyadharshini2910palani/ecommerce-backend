package com.priya.ecom_proj.service;

import com.priya.ecom_proj.model.User;
import com.priya.ecom_proj.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User register(User user){
        return repo.save(user);
    }
    public User login(String email, String password){

        User user = repo.findByEmail(email);

        if(user != null && user.getPassword().equals(password)){
            return user;
        }

        return null;
    }
}

