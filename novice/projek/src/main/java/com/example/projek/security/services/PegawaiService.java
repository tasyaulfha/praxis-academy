package com.example.projek.security.services;


import com.example.projek.model.Pegawai;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface PegawaiService {
    @NotNull List<Pegawai> getAllPegawai();
    Pegawai getPegawai(@Min(value = 1L, message = "ID Pegawai tidak tersedia")Long id);
    Pegawai save(Pegawai pegawai);
}
