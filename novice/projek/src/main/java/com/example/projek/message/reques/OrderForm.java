package com.example.projek.message.reques;

import com.example.projek.model.OrderProduct;

import java.util.List;

public class OrderForm {
    private Integer jumlah;
    private String status;
    private List<OrderProductForm> orderProducts;

    public OrderForm() {
        super();
    }

    public OrderForm(Integer jumlah, String status, List<OrderProductForm> orderProducts) {
        this.jumlah = jumlah;
        this.status = status;
        this.orderProducts = orderProducts;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderProductForm> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductForm> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
