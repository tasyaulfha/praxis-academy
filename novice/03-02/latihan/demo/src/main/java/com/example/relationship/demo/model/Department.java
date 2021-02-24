package com.example.relationship.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String name;
    private String faculty;


    public void setId(Long id) {
         Id = id;
    }
    public Long getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

   public void setFaculty(String faculty) {
       this.faculty = faculty;
   }
   public String getFaculty() {
       return faculty;
   }
}