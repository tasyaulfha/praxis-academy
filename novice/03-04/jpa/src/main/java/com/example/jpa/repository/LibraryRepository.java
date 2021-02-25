package com.example.jpa.repository;

import com.example.jpa.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository <Library,Long> {
}
