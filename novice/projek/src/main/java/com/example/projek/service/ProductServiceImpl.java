package com.example.projek.service;

import com.example.projek.dto.ProductDto;
import com.example.projek.model.Product;
import com.example.projek.repository.ProductRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


    @Override
    public List<ProductDto> getAllProducts() {
       return productRepository.findAll().stream().map(product -> new ProductDto(
                product.getId(),
                product.getName(),
                product.getUkuran(),
                product.getHarga(),
                product.getHarga()-2000,
                product.getHarga()-4000,
                product.getHarga()-6500,
                product.getCategory())).collect(Collectors.toList());
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
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product){
        productRepository.save(product);
        return product;
    }



}
