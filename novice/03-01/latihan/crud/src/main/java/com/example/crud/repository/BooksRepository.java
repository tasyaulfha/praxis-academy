package com.example.crud.repository;


import java.util.Optional;

import com.example.crud.model.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books,Long>{

	Optional<Books> findById(Long id);

	void deleteById(Long bookid);
    
}