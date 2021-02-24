package com.example.onetoone.controller;


import com.example.onetoone.model.User;
import com.example.onetoone.repository.UserRepository;
import com.example.onetoone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
//    @GetMapping("/getUser/{id}")
//    public User getUser(@PathVariable Long id){
//        return userRepository.findById(id);
//    }
    @DeleteMapping(path = "/{id}")
    private void deleteUser (@PathVariable Long id){
        userRepository.deleteById(id);
    }
    @PostMapping(path = "/")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
