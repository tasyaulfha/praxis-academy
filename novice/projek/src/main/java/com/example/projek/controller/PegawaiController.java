package com.example.projek.controller;

import com.example.projek.model.Pegawai;
import com.example.projek.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pegawai")
public class PegawaiController {
    @Autowired
    PegawaiService pegawaiService;

    public PegawaiController(PegawaiService pegawaiService) {
        this.pegawaiService = pegawaiService;
    }

    @GetMapping("/")
    public List<Pegawai> getAllPegawai(){
        return pegawaiService.getAllPegawai();
    }
    @PostMapping("/")
    public Pegawai addPegawai(@RequestBody Pegawai pegawai){
        return pegawaiService.save(pegawai);
    }
    @DeleteMapping("/{id}")
    public void deletePegawai(@PathVariable Long id){
        pegawaiService.deletePegawai(id);
    }
    @PutMapping("/")
    public Pegawai updatePegawai(@PathVariable Long id, @RequestBody Pegawai pegawai){
        pegawaiService.updatePegawai(id, pegawai);
        return pegawai;
    }





}
