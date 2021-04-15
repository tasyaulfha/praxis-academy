package com.example.projek.repository;

import com.example.projek.model.Harga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HargaRepository extends JpaRepository<Harga, Long> {
}
