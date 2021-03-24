package com.example.projek.service;

import com.example.projek.model.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {

    @NotNull Iterable<Order> getAllOrders();
    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);
    Order update(Long id,Order order);
    void deleteOrder(Long id);
}