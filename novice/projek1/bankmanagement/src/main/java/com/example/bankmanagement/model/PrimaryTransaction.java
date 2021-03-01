package com.example.bankmanagement.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class PrimaryTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String type;
    private String status;
    private double amount;
    private BigDecimal availableBalance;

    @ManyToOne
    @JoinColumn(name = "primary_account_id")
    private PrimaryAccount primaryAccount;

    public PrimaryTransaction(Date date, String s, String account, String finished, double v, BigDecimal accountBalance, PrimaryAccount primaryAccount){

    }
    private PrimaryTransaction(Date date,String type, String status, double amount, BigDecimal availableBalance, PrimaryAccount primaryAccount ){
        this.date=date;
        this.type=type;
        this.status=status;
        this.amount= amount;
        this.availableBalance=availableBalance;
        this.primaryAccount=primaryAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PrimaryAccount getPrimaryAccount() {
        return primaryAccount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public double getAmount() {
        return amount;
    }

    public void setPrimaryAccount(PrimaryAccount primaryAccount) {
        this.primaryAccount = primaryAccount;
    }
}
