package com.example.projek.security.services;

import com.example.projek.model.OrderProduct;
import com.example.projek.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class OrderProductServiceImpl implements OrderProductService{

    private OrderProductRepository orderProductRepository;
    @Override
    public OrderProduct create( OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
