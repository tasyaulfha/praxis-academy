package com.example.relationship.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Department {
    @Id
    private Integer Id;
    private String name;
    private String description;

    public Department(Integer id, String name, String description){
        Id = id;
        this.name=name;
        this.description=description;
    }
    @OneToMany(mappedBy = "deparment")
    private List<Students> students;
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}