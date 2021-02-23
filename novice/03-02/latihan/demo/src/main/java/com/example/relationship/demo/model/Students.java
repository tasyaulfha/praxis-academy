package com.example.relationship.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Students {
    @Id
    private Integer Id;
    private String firstName;
    private String lastName;

    @ManyToOne
    private Department department;

    public Students(Integer id, String firstName, String lastName){
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}
