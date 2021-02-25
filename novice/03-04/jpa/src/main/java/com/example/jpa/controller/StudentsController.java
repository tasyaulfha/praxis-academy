package com.example.jpa.controller;


import com.example.jpa.model.Students;
import com.example.jpa.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="students")
public class StudentsController {
    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping(path="/getStudents")
    public List<Students> getAllStudents(){
        return studentsRepository.findAll();
    }
    @GetMapping(path="/getStudents/{id}")
    public Optional<Students> getStudents(@PathVariable Long id){
        return studentsRepository.findById(id);
    }
    @DeleteMapping(path="/")
    private void deleteStudents(@PathVariable Long id){
        studentsRepository.deleteById(id);
    }
    @PostMapping(path="/")
    public Students addStudents(@RequestBody Students students){
        return studentsRepository.save(students);
    }
}
