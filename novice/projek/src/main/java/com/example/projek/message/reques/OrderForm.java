package com.example.projek.message.reques;

import com.example.projek.model.OrderProduct;

import java.util.List;

public class OrderForm {
    private String status;
    private List<OrderProductForm> orderProducts;

    public OrderForm() {
        super();
    }

    public OrderForm(String status, List<OrderProductForm> orderProducts) {
        this.status = status;
        this.orderProducts = orderProducts;
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
