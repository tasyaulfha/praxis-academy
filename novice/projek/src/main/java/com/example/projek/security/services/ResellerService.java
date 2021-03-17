package com.example.projek.security.services;


import com.example.projek.model.Reseller;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ResellerService {
    @NotNull Iterable<Reseller> getAllResellers();
    Reseller getReseller (@Min(value=1L, message = "ID Reseller Salah")Long id);
    Reseller save (Reseller reseller);
}
