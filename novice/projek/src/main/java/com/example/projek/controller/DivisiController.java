package com.example.projek.controller;


import com.example.projek.model.Divisi;
import com.example.projek.service.DivisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jwt")
public class DivisiController {

    @Autowired
    DivisiService divisiService;

    public DivisiController(DivisiService divisiService) {
        this.divisiService = divisiService;
    }

    @GetMapping("/divisi")
    public List<Divisi> getAllDivisi(){
        return(List<Divisi>)  divisiService.getAllDivisi();
    }
    @PostMapping("/divisi")
    public Divisi addDivisi(@RequestBody Divisi divisi){
        return divisiService.save(divisi);
    }

    @DeleteMapping("/divisi/{id}")
    public void deleteMapping(@PathVariable Long id, Divisi divisi){
        divisiService.deleteDivisi(id);
    }
    @PutMapping("/divisi/{id}")
    public Divisi updateDivisi(Long id, Divisi divisi){
        divisiService.updateDivisi(id, divisi);
        return divisi;
    }
}
