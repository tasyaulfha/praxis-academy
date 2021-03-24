package com.example.projek.service;

import com.example.projek.model.Divisi;
import com.example.projek.repository.DivisiRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class DivisiServiceImpl implements DivisiService{
    private DivisiRepository divisiRepository;

    public DivisiServiceImpl(DivisiRepository divisiRepository) {
        this.divisiRepository = divisiRepository;
    }

    @Override
    public @NotNull Iterable<Divisi> getAllDivisi() {
        return divisiRepository.findAll();
    }

    @Override
    public Divisi getDivisi(Long id) {
        return divisiRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ID divisi salah"));
    }

    @Override
    public Divisi save(Divisi divisi) {
        return divisiRepository.save(divisi);
    }

    @Override
    public Divisi updateDivisi(Long id, Divisi divisi) {
        divisiRepository.save(divisi);
        return divisi;
    }

    @Override
    public Divisi deleteDivisi(Long id) {
        Divisi divisi = divisiRepository.findById(id).orElse(null);
        return divisi;
    }
}
