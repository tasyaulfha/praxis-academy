package com.example.projek.security.services;


import com.example.projek.model.Reseller;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ResellerService {
    @NotNull List<Reseller> getAllResellers();
    Reseller getReseller (@Min(value=1L, message = "ID Reseller Salah")Long id);
    Reseller save (Reseller reseller);
}
