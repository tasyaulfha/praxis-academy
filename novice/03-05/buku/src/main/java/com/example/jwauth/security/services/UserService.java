package com.example.jwauth.security.services;


import com.example.jwauth.model.User;
import com.example.jwauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        List<User>users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public User getUser(Long id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }
   public User updateUser(Long id, User user){
        userRepository.save(user);
        return user;
   }
   public User deleteUser(Long id){
        User user = userRepository.findById(id).orElse(null);
        return user;
   }
   public User addUser(User user){
        userRepository.save(user);
        return user;
   }

}
