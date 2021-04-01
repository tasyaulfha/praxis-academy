package com.example.projek.dto;

import com.example.projek.model.Category;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class ProductDto {
    private Long id;

    @NotNull
    @Basic(optional = false)
    private String name;
    private int ukuran;

    private double hargaTipe1;
    private double hargaTipe2;
    private double hargaTipe3;
    private double hargaTipe4;

    @ManyToOne
    private Category category;

    public ProductDto() {
        super();
    }

    public ProductDto(Long id, @NotNull String name, int ukuran, double hargaTipe1, double hargaTipe2, double hargaTipe3, double hargaTipe4, Category category) {
        this.id = id;
        this.name = name;
        this.ukuran = ukuran;
        this.hargaTipe1 = hargaTipe1;
        this.hargaTipe2 = hargaTipe2;
        this.hargaTipe3 = hargaTipe3;
        this.hargaTipe4 = hargaTipe4;
        this.category = category;
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

    public double getHargaTipe1() {
        return hargaTipe1;
    }

    public void setHargaTipe1(double hargaTipe1) {
        this.hargaTipe1 = hargaTipe1;
    }

    public double getHargaTipe2() {
        return hargaTipe2;
    }

    public void setHargaTipe2(double hargaTipe2) {
        this.hargaTipe2 = hargaTipe2;
    }

    public double getHargaTipe3() {
        return hargaTipe3;
    }

    public void setHargaTipe3(double hargaTipe3) {
        this.hargaTipe3 = hargaTipe3;
    }

    public double getHargaTipe4() {
        return hargaTipe4;
    }

    public void setHargaTipe4(double hargaTipe4) {
        this.hargaTipe4 = hargaTipe4;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
