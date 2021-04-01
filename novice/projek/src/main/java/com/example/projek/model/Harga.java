package com.example.projek.model;

import javax.persistence.*;

@Entity
@Table(name="harga")
public class Harga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double harga;
}
