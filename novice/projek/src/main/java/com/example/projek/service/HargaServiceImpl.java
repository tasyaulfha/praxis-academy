package com.example.projek.service;


import com.example.projek.model.Harga;
import com.example.projek.repository.HargaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class HargaServiceImpl implements HargaService {
    private HargaRepository hargaRepository;

    public HargaServiceImpl(HargaRepository hargaRepository) {
        this.hargaRepository = hargaRepository;
    }

    @Override
    public @NotNull List<Harga> getAllHarga(){
        return hargaRepository.findAll();
    }

    @Override
    public Harga getHarga(Long id) {
        return hargaRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Harga save(Harga harga) {
        return hargaRepository.save(harga);
    }

    @Override
    @Transactional
    public Harga updateHarga(Long id, Harga harga) {
        hargaRepository.save(harga);
        return harga;
    }

    @Override
    public Harga deleteHarga(Long id) {
        Harga harga = hargaRepository.findById(id).orElse(null);
        return harga;
    }


}
