package com.example.projek.security.services;

import com.example.projek.model.Divisi;
import com.example.projek.repository.DivisiRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    public Divisi getDivisi(@Min(value = 1L, message = "Id Divisi tidak ditemukan") Long id) {
        return divisiRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ID divisi salah"));
    }

    @Override
    public Divisi save(Divisi divisi) {
        return divisiRepository.save(divisi);
    }
}
