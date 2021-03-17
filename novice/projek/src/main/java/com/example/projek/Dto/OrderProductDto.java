package com.example.projek.Dto;

import com.example.projek.model.Product;

public class OrderProductDto {
    private Product product;
    private Integer jumlah;

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
