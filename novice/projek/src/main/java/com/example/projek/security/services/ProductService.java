package com.example.projek.security.services;


import com.example.projek.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {
    @NotNull Iterable<Product> getAllProducts();
    Product getProduct (@Min(value = 1L, message = "Product ID salah")long id);
    Product save (Product product);

}