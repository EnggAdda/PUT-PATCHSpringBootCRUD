package com.example.springbootcrud.repo;

import com.example.springbootcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
