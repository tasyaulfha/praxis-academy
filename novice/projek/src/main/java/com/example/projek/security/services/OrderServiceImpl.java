package com.example.projek.security.services;


import com.example.projek.model.Order;
import com.example.projek.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public @NotNull List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
