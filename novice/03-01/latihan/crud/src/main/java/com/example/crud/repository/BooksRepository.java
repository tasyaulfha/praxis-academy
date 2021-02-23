package com.example.crud.repository;


import com.example.crud.model.Books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books,Integer>{
    
}