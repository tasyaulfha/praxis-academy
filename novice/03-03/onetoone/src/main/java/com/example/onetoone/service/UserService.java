package com.example.onetoone.service;


import com.example.onetoone.model.User;
import com.example.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser(){
        List<User>Users = new ArrayList<>();
        userRepository.findAll().forEach(Users::add);
        return Users;
    }
    public User getUserById (Long id){
        User user =userRepository.findById(id).orElse(null);
        return user;
    }
    public User addUser(User user){
        userRepository.save(user);
        return user;
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public User updateUser(Long id, User user){
        userRepository.save(user);
        return user;
    }


}
