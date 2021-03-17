package com.example.projek.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Date tanggal;
}
