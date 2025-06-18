package com.companysebasth.ject_bank.models;

public class InvestmentAccount extends Account{
    private double investmentAmount;
    private String investmentType;
    private String riskLevel;
    private double interestRate;

    // Create a constructor for InvestmentAccount
    public InvestmentAccount(String accountNumber, String accountType, double balance, String currency, String ownerName, String ownerLastName, Long ownerIdUser, String ownerEmail, int ownerPhoneNumber, String creationDate, String lastTransactionDate, String status, double investmentAmount, String investmentType, String riskLevel) {
        super(accountNumber, accountType, balance, currency, ownerName, ownerLastName, ownerIdUser, ownerEmail, ownerPhoneNumber, creationDate, lastTransactionDate, status);
        this.investmentAmount = investmentAmount;
        this.investmentType = investmentType;
        this.riskLevel = riskLevel;
    }

    // Create a default constructor for InvestmentAccount
    public InvestmentAccount(double interestRate, double investmentAmount, String investmentType) {
        this.investmentAmount = this.investmentAmount;
        this.investmentType = investmentType;
        this.riskLevel = riskLevel;
        this.interestRate = this.interestRate;
    }

    // Create getters and setters for InvestmentAccount attributes
    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    //metodo deposit para InvestmentAccount
    public void deposit(double investmentAmount){
        if (investmentAmount < 25000){
            System.out.println("El monto de inversion debe ser igual o mayor $25,000.");
        } else {
            setBalance(getBalance() + investmentAmount);
            System.out.println("Deposito exitoso. nuevo saldo: " + getBalance());
        }
    }

    // metodo withdraw para InvestmentAccount
    public void withdraw(double investmentAmount) {
        if (investmentAmount > getBalance() && investmentAmount <= 10000) {
            System.out.println("Fondos insuficientes para retirar " + investmentAmount + ". Saldo actual: " + getBalance());
        } else {
            setBalance(getBalance() - investmentAmount);
            System.out.println("Retiro exitoso. Nuevo saldo: " + getBalance());
        }
    }
}
