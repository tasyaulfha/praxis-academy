package com.example.projek.service;


import com.example.projek.model.Order;
import com.example.projek.model.Reseller;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ResellerService {
    @NotNull List<Reseller> getAllResellers();
    Reseller getReseller (Long id);
    Reseller save (Reseller reseller);
    Reseller updateReseller(Long id, Reseller reseller);
    Reseller deleteReseller(Long id);

}
