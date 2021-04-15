package com.example.projek.dto;

import com.example.projek.model.Category;
import com.example.projek.model.Harga;

import javax.persistence.Basic;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductDto {
    private Long id;

    @NotNull
    @Basic(optional = false)
    private String name;
    private int ukuran;


    private String varian;
    private Category category;
    private List<Harga> hargas;

    public ProductDto() {
        super();
    }

    public ProductDto(Long id, @NotNull String name, int ukuran, String varian, Category category, List<Harga> hargas) {
        this.id = id;
        this.name = name;
        this.ukuran = ukuran;
        this.varian = varian;
        this.category = category;
        this.hargas = hargas;
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

    public List<Harga> getHargas() {
        return hargas;
    }

    public void setHargas(List<Harga> hargas) {
        this.hargas = hargas;
    }

    public String getVarian() {
        return varian;
    }

    public void setVarian(String varian) {
        this.varian = varian;
    }
}
