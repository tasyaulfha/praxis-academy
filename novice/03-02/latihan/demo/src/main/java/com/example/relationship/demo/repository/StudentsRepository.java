package com.example.relationship.demo.repository;

import com.example.relationship.demo.model.Students;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentsRepository extends JpaRepository<Students,Long> {
}
