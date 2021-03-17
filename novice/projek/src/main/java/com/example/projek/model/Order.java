package com.example.projek.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reseller", referencedColumnName = "id", insertable = false, updatable = false)
    private Reseller reseller;

    private Long id_reseller;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produk", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    private Long id_produk;

    private Date tanggal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}