package com.example.projek.security.services;


import com.example.projek.model.Divisi;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface DivisiService {
    @NotNull Iterable<Divisi> getAllDivisi();
    Divisi getDivisi(@Min(value =1L, message = "Id Divisi tidak ditemukan")Long id);
    Divisi save(Divisi divisi);
}
