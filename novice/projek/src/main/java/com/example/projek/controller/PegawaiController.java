package com.example.projek.controller;

import com.example.projek.model.Pegawai;
import com.example.projek.security.services.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/pegawai")
public class PegawaiController {
    @Autowired
    PegawaiService pegawaiService;

    public PegawaiController(PegawaiService pegawaiService) {
        this.pegawaiService = pegawaiService;
    }

    @GetMapping("/pegawai")
    public List<Pegawai> getAllPegawai(){
        return pegawaiService.getAllPegawai();
    }

    @PostMapping("/pegawai")
    public Pegawai addPegawai(@RequestBody Pegawai pegawai){
        return pegawaiService.save(pegawai);
    }
}
