package com.example.jwauth.controller;


import com.example.jwauth.model.User;
import com.example.jwauth.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jwt")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping( "/user/add")
    @PreAuthorize("hasRole('ADMIN')")
    public User addUser (@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping( "/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }



}
