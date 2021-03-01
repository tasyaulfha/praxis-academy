package com.example.bankmanagement.repository;

import com.example.bankmanagement.model.PrimaryAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryAccountRepository extends JpaRepository<PrimaryAccount,Long> {
    PrimaryAccount findByAccountNumber(int accountNumber);
}
