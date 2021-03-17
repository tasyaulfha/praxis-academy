package com.example.projek.repository;

import com.example.projek.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
