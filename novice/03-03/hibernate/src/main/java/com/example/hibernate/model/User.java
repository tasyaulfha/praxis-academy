package com.example.hibernate.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=65)

}
