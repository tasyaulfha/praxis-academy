package com.example.onetomany.controller;

import com.example.onetomany.Repository.CartRepository;
import com.example.onetomany.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/getCart")
    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }
    @GetMapping("/")
    public Optional<Cart> getCart(@PathVariable Long id){
        return cartRepository.findById(id);
    }
    @DeleteMapping(path = "/")
    private void deleteCart(@PathVariable Long id){
        cartRepository.deleteById(id);
    }
    @PostMapping("/")
    public Cart addCart(@RequestBody Cart cart){
        return cartRepository.save(cart);
    }
}
