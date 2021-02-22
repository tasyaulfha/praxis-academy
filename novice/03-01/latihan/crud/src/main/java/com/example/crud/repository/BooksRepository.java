package com.example.crud.repository;


import com.example.crud.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books,Integer>{
    
}