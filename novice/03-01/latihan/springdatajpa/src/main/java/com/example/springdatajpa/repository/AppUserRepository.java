package com.example.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springdatajpa.model.AppUser;
    
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{

    
}