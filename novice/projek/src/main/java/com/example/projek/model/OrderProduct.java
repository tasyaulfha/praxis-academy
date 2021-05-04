package com.example.projek.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class OrderProduct {

    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(nullable = false)
    private Integer jumlah;

    public OrderProduct() {
        super();
    }

    public OrderProduct(Order order, Product product, Reseller reseller, Integer jumlah) {
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        pk.setReseller(reseller);
        this.jumlah = jumlah;
    }

    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }

    @Transient
    public Reseller getReseller(){
        return this.pk.getReseller();
    }

    @Transient
    public Double getTotalPrice() {
        List<Harga> listHarga = getProduct().getHarga();
        listHarga.sort((a, b) -> {
            if (a.getMinQuantity() > b.getMinQuantity()) return 1;
            if (a.getMinQuantity() < b.getMinQuantity()) return -1;
            return 0;
        });
        double price=0.0;
        Harga max = null;
        for (Harga harga : listHarga) {
            System.out.println(harga.getMinQuantity());
            if (max == null || (max.getMinQuantity() <= harga.getMinQuantity() && getJumlah() >= harga.getMinQuantity())) {
                max = harga;
            }
        }
        if (max != null) {
            price = (max.getHarga() * getJumlah());
        }
        return price;
    }


    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderProduct other = (OrderProduct) obj;
        if (pk == null) {
            return other.pk == null;
        } else return pk.equals(other.pk);

    }
}