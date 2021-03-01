package com.example.bankmanagement.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class SavingsTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String type;
    private String status;
    private double amount;
    private BigDecimal availableBalance;

    @ManyToOne
    @JoinColumn(name="savings_account_id")
    private SavingsAccount savingsAccount;

    public SavingsTransaction(Date date, String s, String transfer, String finished, double v, BigDecimal accountBalance, SavingsAccount savingsAccount){}
    public SavingsTransaction(Date date,String type, String status, double amount, BigDecimal availableBalance, SavingsAccount savingsAccount){
        this.date=date;
        this.type=type;
        this.status=status;
        this.amount=amount;
        this.availableBalance=availableBalance;
        this.savingsAccount= savingsAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

}
