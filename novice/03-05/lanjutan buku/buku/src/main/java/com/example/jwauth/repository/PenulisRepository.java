package com.example.jwauth.repository;

import com.example.jwauth.model.Penulis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenulisRepository extends JpaRepository<Penulis, Long> {

}
