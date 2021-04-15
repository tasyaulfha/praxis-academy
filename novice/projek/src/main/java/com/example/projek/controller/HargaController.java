package com.example.projek.controller;

import com.example.projek.model.Harga;
import com.example.projek.service.HargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HargaController {

    @Autowired
    HargaService hargaService;

    public HargaController(HargaService hargaService) {
        this.hargaService = hargaService;
    }

    @GetMapping("/harga")
    public List<Harga> getAllHarga(){
        return(List<Harga>)  hargaService.getAllHarga();
    }

    @PostMapping("/harga")
    public Harga addHarga(@RequestBody Harga harga){
        return hargaService.save(harga);
    }

    @DeleteMapping("/harga/{id}")
    public void deleteHarga(@PathVariable Long id, Harga harga){
        hargaService.deleteHarga(id);
    }

    @PutMapping("/harga/{id}")
    public Harga updateHarga (Long id, Harga harga){
        hargaService.updateHarga(id, harga);
        return harga;
    }
}
