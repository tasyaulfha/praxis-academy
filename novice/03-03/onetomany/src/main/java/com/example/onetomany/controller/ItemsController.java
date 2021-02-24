package com.example.onetomany.controller;

import com.example.onetomany.Repository.ItemsRepository;
import com.example.onetomany.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="items")
public class ItemsController {
    @Autowired
    private ItemsRepository itemsRepository;

    @GetMapping("/getItems")
    public List<Items> getAllItems(){
        return itemsRepository.findAll();
    }
    @GetMapping("/")
    public Optional<Items> getItems(@PathVariable Long id){
        return itemsRepository.findById(id);
    }
    @DeleteMapping(path = "/")
    private void deleteItems(@PathVariable Long id){
        itemsRepository.deleteById(id);
    }
    @PostMapping("/")
    public Items addCart(@RequestBody Items items){
        return itemsRepository.save(items);
    }
}
