package com.priya.ecom_proj.repo;

import com.priya.ecom_proj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
