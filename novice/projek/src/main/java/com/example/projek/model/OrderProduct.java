package com.example.projek.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class OrderProduct {
    @EmbeddedId
    @JsonIgnore
    private OrderProductPR pr;

    @Column(nullable = false)
    private Integer jumlah;


    public OrderProduct(){
        super();
    }
    public OrderProduct(Order order, Product product, Integer jumlah){
        pr = new OrderProductPR();
        pr.setOrder(order);
        pr.setProduct(product);
        this.jumlah=jumlah;
    }

    @Transient
    public Product getProduct(){
        return this.pr.getProduct();
    }
    @Transient
    public Double getTotalPrice(){
        return getProduct().getHarga()*getJumlah();
    }

    public OrderProductPR getPr(){
        return pr;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setPr(OrderProductPR pr) {
        this.pr = pr;
    }
    
}
