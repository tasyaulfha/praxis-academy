package com.example.projek.service;


import com.example.projek.model.Pegawai;
import com.example.projek.repository.PegawaiRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service

public class PegawaiServiceImpl implements PegawaiService{
    private PegawaiRepository pegawaiRepository;

    public PegawaiServiceImpl(PegawaiRepository pegawaiRepository) {
        this.pegawaiRepository = pegawaiRepository;
    }

    @Override
    public @NotNull List<Pegawai> getAllPegawai() {
        return pegawaiRepository.findAll();
    }

    @Override
    public Pegawai getPegawai(Long id) {
        return pegawaiRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ID pegawai salah"));
    }

    @Override
    public Pegawai save(Pegawai pegawai) {
        return pegawaiRepository.save(pegawai);
    }

    @Override
    public Pegawai deletePegawai(Long id) {
        Pegawai pegawai= pegawaiRepository.findById(id).orElse(null);
        return pegawai;
    }

    @Override
    public Pegawai updatePegawai(Long id, Pegawai pegawai) {
        pegawaiRepository.save(pegawai);
        return pegawai;
    }
}
