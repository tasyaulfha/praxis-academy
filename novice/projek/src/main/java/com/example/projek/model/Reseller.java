package com.example.projek.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="reseller")
public class Reseller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Basic(optional = false)
    private String name;
    private String username;
    private String nama_toko;
    private String phone;
    private String alamat;

    @Email
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produk", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Product> products;

    private Long id_produk;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Order> orders;

    private Long id_order;

    public Reseller(Long id, @NotNull String name, String username, String nama_toko, String phone, String alamat, @Email String email, List<Product> products, Long id_produk, List<Order> orders, Long id_order) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.nama_toko = nama_toko;
        this.phone = phone;
        this.alamat = alamat;
        this.email = email;
        this.products = products;
        this.id_produk = id_produk;
        this.orders = orders;
        this.id_order = id_order;
    }

    public Reseller() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId_produk() {
        return id_produk;
    }

    public void setId_produk(Long id_produk) {
        this.id_produk = id_produk;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }
}
