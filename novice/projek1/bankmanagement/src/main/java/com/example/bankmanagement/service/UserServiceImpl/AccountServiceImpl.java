package com.example.bankmanagement.service.UserServiceImpl;

import com.example.bankmanagement.model.*;
import com.example.bankmanagement.repository.PrimaryAccountRepository;
import com.example.bankmanagement.repository.SavingsAccountRepository;
import com.example.bankmanagement.service.AccountService;
import com.example.bankmanagement.service.TransactionService;
import com.example.bankmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    private static int nextAccountNumber = 11223101;

    @Autowired
    private PrimaryAccountRepository primaryAccountRepository;

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;




    @Override
    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount= new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountRepository.save(primaryAccount);

        return primaryAccountRepository.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingsAccountRepository.save(savingsAccount);
        return savingsAccountRepository.findByAccountNumber(savingsAccount.getAccountNumber());
    }

    @Override
    public void deposit(String accountType, double amount, Principal principal) {

        User user = userService.findByUsername(principal.getName());

        if (accountType.equalsIgnoreCase("Primary")){
            PrimaryAccount primaryAccount = new PrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
            primaryAccountRepository.save(primaryAccount);

            Date date = new Date();
            PrimaryTransaction primaryTransaction= new PrimaryTransaction(date, "Deposit to primary account ", "Account","Finished",amount,primaryAccount.getAccountBalance(), primaryAccount);
            transactionService.savePrimaryDepositTransaction(primaryTransaction);
        }
        else if(accountType.equalsIgnoreCase("Savings")){
            SavingsAccount savingsAccount= new SavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));
            savingsAccountRepository.save(savingsAccount);

            Date date = new Date();
            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Deposit to savings account", "Account","finished", amount,savingsAccount.getAccountBalance(),savingsAccount);
            transactionService.saveSavingsDepositTransaction(savingsTransaction);
        }

    }

    @Override
    public void withdraw(String accountType, double amount, Principal principal) {

        User user = userService.findByUsername(principal.getName());

        if (accountType.equalsIgnoreCase("Primary")){
            PrimaryAccount primaryAccount= new PrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            primaryAccountRepository.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction= new PrimaryTransaction(date,"Withdraw from primary account", "Account","Finished", amount, primaryAccount.getAccountBalance(),primaryAccount);
            transactionService.savePrimaryWithDrawTransaction(primaryTransaction);
        }
        else if (accountType.equalsIgnoreCase("Savings")){
            SavingsAccount savingsAccount = new SavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccountRepository.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "withdraw from savings account","Account","Finished", amount, savingsAccount.getAccountBalance(),savingsAccount);
            transactionService.saveSavingsWithDrawTransaction(savingsTransaction);
        }

    }
    private int accountGen(){
        return ++nextAccountNumber;
    }
}
