package com.example.projek.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Basic(optional = false)
    private String name;
    private int ukuran;
    private Double harga;

    public Product(Long id, @NotNull String name, Double harga, int ukuran) {
        this.id = id;
        this.name=name;
        this.harga=harga;
        this.ukuran=ukuran;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }

    public Long getId() {
        return id;
    }

    public Double getHarga() {
        return harga;
    }

    public int getUkuran() {
        return ukuran;
    }
}
