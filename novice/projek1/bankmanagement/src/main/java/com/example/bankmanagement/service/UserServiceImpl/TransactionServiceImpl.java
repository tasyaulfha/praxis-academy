package com.example.bankmanagement.service.UserServiceImpl;

import com.example.bankmanagement.model.*;
import com.example.bankmanagement.repository.*;
import com.example.bankmanagement.service.TransactionService;
import com.example.bankmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private UserService userService;
    @Autowired
    private PrimaryTransactionRepository primaryTransactionRepository;
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Autowired
    private PrimaryAccountRepository primaryAccountRepository;
    @Autowired
    private SavingsTransactionalRepository savingsTransactionalRepository;
    @Autowired
    private RecipientRepository recipientRepository;

    public List<PrimaryTransaction> findPrimaryTransactionList(String username){
        User user = userService.findByUsername(username);
        List<PrimaryTransaction> primaryTransactionList = user.getPrimaryAccount().getPrimaryTransactionList();

        return primaryTransactionList;
    }
    public List<SavingsTransaction> findSavingsTransactionList(String username){
        User user = userService.findByUsername(username);
        List<SavingsTransaction> savingsTransactionList = user.getSavingsAccount().getSavingsTransactionList();

        return savingsTransactionList;
    }
    public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction){
        primaryTransactionRepository.save(primaryTransaction);
    }
    public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction){
        savingsTransactionalRepository.save(savingsTransaction);
    }
    public void savePrimaryWithDrawTransaction(PrimaryTransaction primaryTransaction){
        primaryTransactionRepository.save(primaryTransaction);
    }
    public void saveSavingsWithDrawTransaction(SavingsTransaction savingsTransaction){
        savingsTransactionalRepository.save(savingsTransaction);
    }

    public void beetweenAccountTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws
            Exception{
        if (transferFrom.equalsIgnoreCase("Primary")&& transferTo.equalsIgnoreCase("Savings")){
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            primaryAccountRepository.save(primaryAccount);
            savingsAccountRepository.save(savingsAccount);

            Date date = new Date();
            PrimaryTransaction primaryTransaction= new PrimaryTransaction(date, "Between account transfer from"+ transferFrom +
                    "to"+ transferTo, "Account","Finished", Double.parseDouble(amount),primaryAccount.getAccountBalance(),primaryAccount);
            primaryTransactionRepository.save(primaryTransaction);
        } else if(transferFrom.equalsIgnoreCase("Savings")&& transferTo.equalsIgnoreCase("Primary")) {
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            primaryAccountRepository.save(primaryAccount);
            savingsAccountRepository.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction= new SavingsTransaction(date, "Between account transfer from"+ transferFrom +"to"+transferTo,"transfer","finished",Double.parseDouble(amount),savingsAccount.getAccountBalance(),savingsAccount);

        }
        else {
            throw new Exception("Invalid transfer!");
        }
    }
    public List<Recipient> findRecipientList(Principal principal){
        String username = principal.getName();
        List<Recipient> recipientList = recipientRepository.findAll().stream()
                .filter(recipient -> username.equals(recipient.getUser().getUsername()))
                .collect(Collectors.toList());

        return recipientList;
    }

    public Recipient saveRecipient(Recipient recipient){
        return recipientRepository.save(recipient);
    }
    public Recipient findRecipientByName (String recipientName){
        return recipientRepository.findByName(recipientName);
    }
    public void deleteRecipientByName (String recipientName){
        recipientRepository.deleteByName(recipientName);
    }

    public void toSomeoneElseTransfer(Recipient recipient, String accountType, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount){
        if(accountType.equalsIgnoreCase("Primary")){
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            primaryAccountRepository.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, " Transfer to recipient "+ recipient.getName(),"Transfer","Finished", Double.parseDouble(amount),primaryAccount.getAccountBalance(),primaryAccount);
            primaryTransactionRepository.save(primaryTransaction);
        }
        else if(accountType.equalsIgnoreCase("Savings")){
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccountRepository.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date,"Transfer to recipient"+recipient.getName(),"Transfer","Finished",Double.parseDouble(amount),savingsAccount.getAccountBalance(),savingsAccount);
            savingsTransactionalRepository.save(savingsTransaction);
        }
    }

}
