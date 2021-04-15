package com.example.projek.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Basic(optional = false)
    private String name;
    private int ukuran;
    private String varian;

    @ManyToOne
    private Category category;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "harga_id",referencedColumnName = "id")
    @JsonIgnoreProperties("products")
    private List<Harga> harga = new ArrayList<>();

    public Product() {
        super();
    }

    public Product(Long id, @NotNull String name, int ukuran, String varian, Category category, @Valid List<Harga> harga) {
        this.id = id;
        this.name = name;
        this.ukuran = ukuran;
        this.varian = varian;
        this.category = category;
        this.harga = harga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUkuran() {
        return ukuran;
    }

    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getVarian() {
        return varian;
    }

    public void setVarian(String varian) {
        this.varian = varian;
    }


    public void setHarga(List<Harga> harga) {
        this.harga = harga;
    }

    public List<Harga> getHarga() {
        return harga;
    }
}
