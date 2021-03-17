package com.example.projek.security.services;

import com.example.projek.model.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Validated
public interface OrderService {
    @NotNull List<Order> getAllOrder();
    Optional<Order> getOrder(Long id);
    Order save(Order order);
}
