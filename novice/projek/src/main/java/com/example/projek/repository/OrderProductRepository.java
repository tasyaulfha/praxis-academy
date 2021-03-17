package com.example.projek.repository;

import com.example.projek.model.OrderProduct;
import com.example.projek.model.OrderProductPR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPR> {
}
