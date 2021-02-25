package com.example.jpa.model;

import javax.persistence.*;

@Entity
@Table(name="library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Library(Long id, String name){
        super();
        this.id=id;
        this.name=name;
    }
    public Library(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
