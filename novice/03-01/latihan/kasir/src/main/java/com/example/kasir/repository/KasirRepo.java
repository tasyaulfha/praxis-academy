package com.example.kasir.repository;

import com.example.kasir.model.Kasir;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface KasirRepo extends CrudRepository<Kasir, Long> {}