package com.example.relationship.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Students {

    @ManyToOne(optional = false)
    @JoinColumn(name = "idDepartment", referencedColumnName="id", insertable = false, updatable = false)
    private Department department;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    private Long idDepartment;

   public Department getDepartment(){
       return department;
   }
   public void setDepartment(Department department) {
       this.department = department;
   }

    public Long getId() {
        return Id;
    }
    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }
    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setId(Long id) {
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
