package com.example.bankmanagement.service;

import com.example.bankmanagement.model.PrimaryAccount;
import com.example.bankmanagement.model.SavingsAccount;

import java.security.Principal;

public interface AccountService {
    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();

    void deposit(String accountType, double amount, Principal principal);
    void withdraw(String accountType, double amount, Principal principal);
}
