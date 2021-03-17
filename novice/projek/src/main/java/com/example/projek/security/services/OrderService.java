package com.example.projek.security.services;


import com.example.projek.model.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {
    @NotNull Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "Order tidak boleh kosong")@Valid Order order);

    void update(@NotNull(message = "Order tidak boleh kosong")@Valid Order order);
}
