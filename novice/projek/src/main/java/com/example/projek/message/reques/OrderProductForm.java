package com.example.projek.message.reques;

import com.example.projek.model.Product;

public class OrderProductForm {
    private Product product;
    private Integer jumlah;

    public Product getProduct() {
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
