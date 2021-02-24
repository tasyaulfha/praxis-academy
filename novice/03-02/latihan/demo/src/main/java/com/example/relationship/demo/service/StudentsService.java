package com.example.relationship.demo.service;


import com.example.relationship.demo.model.Students;
import com.example.relationship.demo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {
    @Autowired
    StudentsRepository studentsRepository;

    public List<Students> getAllStudents(){
        List<Students> student = new ArrayList<>();
        studentsRepository.findAll().forEach(student::add);
        return student;
    }
    public Students getStudentsById(Long id){
        Students students = studentsRepository.findById(id).orElse(null);
        return students;
    }
    public Students addStudents(Students students){
        studentsRepository.save(students);
        return students;
    }
    public void delete(Long id){
        studentsRepository.deleteById(id);
    }
    public Students updateStudents(Long id, Students students){
        studentsRepository.save(students);
        return students;
    }


}
