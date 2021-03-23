package com.example.projek.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    @ManyToMany
    @JoinColumn(name = "id_order", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    @Nullable
    private List<Order> order;



    public Product() {
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

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    @Nullable
    public Order getOrder() {
        return (Order) order;
    }

    public void setOrder(@Nullable Order order) {
        this.order = (List<Order>) order;
    }
}
