package com.example.projek.model;

import javax.persistence.*;

@Entity
@Table(name="stok")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_produk", referencedColumnName = "id",insertable = false,updatable = false)
    private Product product;

    private Long id_produk;

    @ManyToOne
    @JoinColumn(name="id_reseller", referencedColumnName = "id",insertable = false,updatable = false)
    private Reseller reseller;

    private Long id_reseller;

    @ManyToOne
    @JoinColumn(name="id_order", referencedColumnName = "id",insertable = false,updatable = false)
    private Order order;

    private Long id_order;

    public Stock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId_produk() {
        return id_produk;
    }

    public void setId_produk(Long id_produk) {
        this.id_produk = id_produk;
    }

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Long getId_reseller() {
        return id_reseller;
    }

    public void setId_reseller(Long id_reseller) {
        this.id_reseller = id_reseller;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }
}
