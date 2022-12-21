package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    void insertUser(User user);

    User getUserById (int id );

    List<User> getAllUsers();

    User updateUserById(User user , int id);

    User updateFieldsOfUserById(int id, Map<String , Optional> map);

    void deleteUserById(int id);
}
