package com.example.kasir.repository;

import java.util.Optional;

import com.example.kasir.model.Kasir;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface KasirRepo extends CrudRepository<Kasir, Long> {
	// Optional<Kasir> findlById(Long id);
}