package com.example.jwauth.controller;


import com.example.jwauth.model.Penulis;
import com.example.jwauth.security.services.PenulisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jwt")
public class PenulisController {

    @Autowired
    PenulisService penulisService;

   @GetMapping("/penulis")
    public List<Penulis> getAllPenulis(){
       return penulisService.getAllPenulis();
   }

   @PostMapping("/penulis/add")
   @PreAuthorize("hasRole('ADMIN')")
    public Penulis addPenulis (@RequestBody Penulis penulis){
       return penulisService.addPenulis(penulis);
   }
   @GetMapping("/penulis/{id}")
    public Penulis getPenulis(@PathVariable Long id){
       return penulisService.getPenulis(id);
   }
   @DeleteMapping("/penulis/{id}")
   @PreAuthorize("hasRole('ADMIN')")
    public void deletePenulis(@PathVariable Long id){
       penulisService.deletePenulis(id);
   }
}
