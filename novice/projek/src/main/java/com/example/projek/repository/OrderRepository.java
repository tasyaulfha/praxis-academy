package com.example.projek.repository;

import com.example.projek.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {
}
