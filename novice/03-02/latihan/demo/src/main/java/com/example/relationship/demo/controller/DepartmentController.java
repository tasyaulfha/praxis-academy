package com.example.relationship.demo.controller;

import com.example.relationship.demo.model.Department;
import com.example.relationship.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getDepartment")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("/getDepartment/{id}")
    public Department getDepartment(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }
    @DeleteMapping(path = "/delete/{id}")
        private void deleteDepartment(@PathVariable Long id){
            departmentService.delete(id);
    }
    @PostMapping(path = "/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }
    }
