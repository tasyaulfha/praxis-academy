package com.example.projek.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private CategoryName nama;

    @OneToMany
    @JsonIgnore
    private List<Product> product;

    public Category() {
        super();
    }

    public Category(Long id, CategoryName nama, List<Product> product) {
        this.id = id;
        this.nama = nama;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryName getNama() {
        return nama;
    }

    public void setNama(CategoryName nama) {
        this.nama = nama;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
