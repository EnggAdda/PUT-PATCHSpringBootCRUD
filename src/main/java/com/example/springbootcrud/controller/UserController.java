package com.example.springbootcrud.controller;

import com.example.springbootcrud.entity.User;
import com.example.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/insert")
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);

    }

    @GetMapping("/User/{id}")
    public User getUserById(@PathVariable int id){
       return userService.getUserById(id);

    }
    @GetMapping("/findAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();

    }

    @PutMapping("/Update/{id}")
    public User updateUserById(@RequestBody User user, @PathVariable int id){
        return userService.updateUserById(user,id);

    }

    @PatchMapping("/UpdateByPatch/{id}")
    public User updateByPatch(@PathVariable int id, @RequestBody Map<String, Optional> map ){
        return userService.updateFieldsOfUserById(id,map);

    }
}
