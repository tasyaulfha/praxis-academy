package com.example.jwauth.security.services;


import com.example.jwauth.model.Penulis;
import com.example.jwauth.repository.PenulisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PenulisService {
    @Autowired
    private PenulisRepository penulisRepository;

    public List<Penulis> getAllPenulis(){
        List<Penulis> penulis1 = new ArrayList<>();
        penulisRepository.findAll().forEach(penulis1::add);
        return penulis1;
    }
    public Penulis getPenulis(Long id){
        Penulis penulis = (Penulis) penulisRepository.findById(id).orElse(null);
        return penulis;
    }
    public Penulis updatePenulis(Long id, Penulis penulis){
        penulisRepository.save(penulis);
        return penulis;
    }
    public Penulis deletePenulis(Long id){
        Penulis penulis = (Penulis) penulisRepository.findById(id).orElse(null);
        return penulis;
    }
    public Penulis addPenulis(Penulis penulis){
        penulisRepository.save(penulis);
        return penulis;
    }
}
