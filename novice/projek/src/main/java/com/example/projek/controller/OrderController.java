package com.example.projek.controller;


import com.example.projek.model.Order;
import com.example.projek.security.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name="/jwt")
public class OrderController {
    @Autowired
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order){
        return orderService.save(order);
    }
}
