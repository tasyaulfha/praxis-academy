package com.example.bankmanagement.repository;

import com.example.bankmanagement.model.PrimaryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryTransactionRepository extends JpaRepository<PrimaryTransaction,Long> {
}
