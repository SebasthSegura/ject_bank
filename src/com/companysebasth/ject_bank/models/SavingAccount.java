package com.companysebasth.ject_bank.models;

public class SavingAccount extends Account{
    private double interestRate;
    private String accountType;

    // Create a constructor for SavingAccount
    public SavingAccount(String accountNumber, String accountType, double balance, String currency, String ownerName, String ownerLastName, Long ownerIdUser, String ownerEmail, int ownerPhoneNumber, String creationDate, String lastTransactionDate, String status, double interestRate) {
        super(accountNumber, accountType, balance, currency, ownerName, ownerLastName, ownerIdUser, ownerEmail, ownerPhoneNumber, creationDate, lastTransactionDate, status);
        this.interestRate = interestRate;
        this.accountType = "Saving Account";
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
}
