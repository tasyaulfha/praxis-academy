package com.example.jwauth.controller;


import com.example.jwauth.model.User;
import com.example.jwauth.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name="/jwt")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping(path = "/user/add")
    @PreAuthorize("hasRole('ADMIN')")
    public User addUser (@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping(path = "/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
    @DeleteMapping(path = "/user/{id}")
    public User deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }



}
