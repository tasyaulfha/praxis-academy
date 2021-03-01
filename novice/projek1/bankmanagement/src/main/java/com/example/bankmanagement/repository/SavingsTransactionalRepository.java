package com.example.bankmanagement.repository;

import com.example.bankmanagement.model.SavingsTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsTransactionalRepository extends JpaRepository<SavingsTransaction,Long> {
}
