package com.example.projek.service;

import com.example.projek.model.Product;
import com.example.projek.repository.ProductRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


    @Override
    public @NotNull List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID Produk Salah"));
    }

    @Override
    public Product save(Product product) {
            return productRepository.save(product);

    }
    @Override
    public Product deleteProduct(Long id){
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product){
        productRepository.save(product);
        return product;
    }



}
