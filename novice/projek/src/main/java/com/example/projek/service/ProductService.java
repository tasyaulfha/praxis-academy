package com.example.projek.service;


import com.example.projek.model.Product;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct (Long id);
    Product save (Product product);
    void deleteProduct(Long id);
    Product updateProduct(Long id, Product product);

}