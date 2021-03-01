package com.example.bankmanagement.repository;

import com.example.bankmanagement.model.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount,Long> {
    SavingsAccount findByAccountNumber(int accountNumber);
}
