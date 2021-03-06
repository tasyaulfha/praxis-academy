package com.example.kasir.controller;

import java.util.List;
import java.util.Optional;

import com.example.kasir.model.Kasir;
import com.example.kasir.repository.KasirRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/kasir")
public class MainController{

    @Autowired
    private KasirRepo kasirRepo;

    @GetMapping(path="/getAll")
    public @ResponseBody Iterable<Kasir> getAllUsers() {
        return kasirRepo.findAll();
    }
    @PostMapping(path="/post")
    public @ResponseBody Kasir addNewUser (@RequestBody Kasir kasir){
        return kasirRepo.save(kasir);
    }
    @GetMapping(path ="/{id}")
    public Optional<Kasir> idKasir(@PathVariable Long id){
         return kasirRepo.findById(id);
     }
    @DeleteMapping("/{id}")
    public void deleteBarang(@PathVariable Long id) {
        kasirRepo.deleteById(id);
    }
    @PutMapping("/{id}")
    Kasir updateKasir (@RequestBody Kasir newKasir, @PathVariable Long id) {
        return kasirRepo.findById(id)
        .map(kasir->{
            kasir.setHarga_barang(newKasir.getHarga_barang());
            kasir.setNama_barang(newKasir.getNama_barang());
            return kasirRepo.save(kasir);
        }).orElseGet(()-> {
            newKasir.setId(id);
            return kasirRepo.save(newKasir);
        });
    }
    
}