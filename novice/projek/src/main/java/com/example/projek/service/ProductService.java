package com.example.projek.service;


import com.example.projek.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ProductService {
    @NotNull List<Product> getAllProducts();
    Product getProduct (Long id);
    Product save (Product product);
    Product deleteProduct(Long id);
    Product updateProduct(Long id, Product product);

}