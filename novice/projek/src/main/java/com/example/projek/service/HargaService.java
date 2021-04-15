package com.example.projek.service;


import com.example.projek.model.Harga;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface HargaService {
    @NotNull List<Harga> getAllHarga();
    Harga getHarga(Long id);
    Harga save(Harga harga);
    Harga updateHarga(Long id, Harga harga);
    Harga deleteHarga (Long id);
}
