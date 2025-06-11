package com.companysebasth.ject_bank.models;

public class SavingAccount extends Account{
    private double interestRate;
    private String accountType;
    private double initialDeposit;


    // Create a constructor for SavingAccount
    public SavingAccount(String accountNumber, String accountType, double balance, String currency, String ownerName, String ownerLastName, Long ownerIdUser, String ownerEmail, int ownerPhoneNumber, String creationDate, String lastTransactionDate, String status, double interestRate, double initialDeposit) {
        super(accountNumber, accountType, balance, currency, ownerName, ownerLastName, ownerIdUser, ownerEmail, ownerPhoneNumber, creationDate, lastTransactionDate, status);
        this.interestRate = interestRate;
        this.accountType = "Saving Account";
    }

    // Create a default constructor for SavingAccount
    public SavingAccount(double interestRate, double initialDeposit, String accountType) {
        this.accountType = accountType; // Default account type
        this.interestRate = this.interestRate;
        this.initialDeposit = this.initialDeposit;
    }

    // Create getters and setters for SavingAccount attributes
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }
    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
}
