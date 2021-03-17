package com.example.projek.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToMany
    @JoinColumn(name="id_reseller", referencedColumnName = "id",insertable = false,updatable = false )
    private Reseller reseller;

    private Long resellers_id;

    @OneToMany
    @JoinColumn(name="id_produk", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    private Long product_id;

    private Date tanggal;

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Long getResellers_id() {
        return resellers_id;
    }

    public void setResellers_id(Long resellers_id) {
        this.resellers_id = resellers_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}

