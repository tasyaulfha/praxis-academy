package com.example.projek.message.reques;

import com.example.projek.model.Product;
import com.example.projek.model.Reseller;

import javax.validation.constraints.Min;

public class OrderProductForm {
    private Product product;
    private Reseller reseller;
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

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }
}
