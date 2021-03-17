package com.example.projek.repository;

import com.example.projek.model.Pegawai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai,Long> {
}
