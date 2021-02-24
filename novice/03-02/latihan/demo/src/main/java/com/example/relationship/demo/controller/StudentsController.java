package com.example.relationship.demo.controller;

import com.example.relationship.demo.model.Students;
import com.example.relationship.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("/getStudents")
    public List<Students> getAllStudents(){
        return studentsService.getAllStudents();
    }
    @GetMapping("/getStudents/{id}")
    public Students getStudents(@PathVariable Long id){
        return studentsService.getStudentsById(id);
    }
    @DeleteMapping(path = "/delete/{id}")
    private void deleteStudents(@PathVariable Long id){
        studentsService.delete(id);
    }
    @PostMapping(path = "/add")
    public Students addStudents(@RequestBody Students students) {
        return studentsService.addStudents(students);
    }
}
