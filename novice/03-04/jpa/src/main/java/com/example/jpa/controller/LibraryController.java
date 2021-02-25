package com.example.jpa.controller;


import com.example.jpa.model.Library;
import com.example.jpa.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="library")
public class LibraryController {
    @Autowired
    LibraryRepository libraryRepository;

    @GetMapping(path="/getLibrary")
    public List<Library> getAllLibrary(){
        return libraryRepository.findAll();
    }
    @GetMapping(path="/getLibrary/{id}")
    public Optional<Library> getLibrary(@PathVariable Long id){
        return libraryRepository.findById(id);
    }
    @DeleteMapping(path = "/")
    private void deleteLibrary(@PathVariable Long id){
        libraryRepository.deleteById(id);
    }
    @PostMapping(path = "/")
    public Library addLibrary(@RequestBody Library library){
        return libraryRepository.save(library);
    }

}
