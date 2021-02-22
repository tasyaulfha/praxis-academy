package com.example.springdatajpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app_user")
public class AppUser {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date joinDate;

    @Override
    public String toString() {
        return String.format(""
                        + "AppUser[id=%d,username=%s,firstName=%s,lastName=%s,joinDate=%tD",
                id, username, firstName, lastName, joinDate);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

}

