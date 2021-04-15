package com.example.projek.controller;


import com.example.projek.model.Product;
import com.example.projek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("/jwt")
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public Product addProduct (@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return MessageFormat.format("ProductDto {0} has been deleted ", id);
    }
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, Product product){
        productService.updateProduct(id,product);
        return product;
    }

}