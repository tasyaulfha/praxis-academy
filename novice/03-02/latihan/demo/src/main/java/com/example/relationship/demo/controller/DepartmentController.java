package com.example.relationship.demo.controller;

import com.example.relationship.demo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public List<Department> findAll(){
        return departmentService.findAll();
    }
    @GetMapping("/deparment{id}")
    public Optional<Department> findById(@PathVariable("id")Integer id){
        return departmentService.findById(id);

    }}
