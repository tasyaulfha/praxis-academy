package com.example.relationship.demo.service;

import com.example.relationship.demo.model.Department;
import com.example.relationship.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }
    public Department getDepartmentById(Long id){
        Department department = departmentRepository.findById(id).orElse(null);
        return department;
    }
    public Department addDepartment(Department department){
        departmentRepository.save(department);
        return department;
    }
    public void delete(Long id){
        departmentRepository.deleteById(id);
    }
    public Department updateDepartment(Long id, Department department){
        departmentRepository.save(department);
        return department;
    }


}
