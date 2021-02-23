package com.example.relationship.demo.controller;

import com.example.relationship.demo.model.Department;
import com.example.relationship.demo.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Students> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/students{id}")
    public Optional<Students> findById(@PathVariable("id")Integer id){
        return studentService.findById(id);

    }}
