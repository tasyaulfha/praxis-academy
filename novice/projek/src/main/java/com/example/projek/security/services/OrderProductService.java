package com.example.projek.security.services;


import com.example.projek.model.OrderProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService {
    OrderProduct create (@NotNull(message = "Produk untuk diorder tidak boleh kosong")@Valid OrderProduct orderProduct);
}
