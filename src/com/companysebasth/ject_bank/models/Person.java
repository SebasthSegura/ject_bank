package com.companysebasth.ject_bank.models;

import java.util.List;

public class Person {
    private String name;
    private String lastName;
    private Long idUser;
    private String email;
    private int phoneNumber;
    private List<InvestmentAccount> investmentAccounts;
    private List<SavingAccount> savingAccounts;

    //creat  e a constructor generic for Person
    public Person(String name, String lastName, Long idUser, String email, int phoneNumber, List<InvestmentAccount> investmentAccounts, List<SavingAccount> savingAccounts){
        this.name = name;
        this.lastName = lastName;
        this.idUser = idUser;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.investmentAccounts = investmentAccounts;
        this.savingAccounts = savingAccounts;
    }

    //create getters and setters for all attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<InvestmentAccount> getInvestmentAccounts() {
        return investmentAccounts;
    }

    public void setInvestmentAccounts(List<InvestmentAccount> investmentAccounts) {
        this.investmentAccounts = investmentAccounts;
    }

    public List<SavingAccount> getSavingAccounts() {
        return savingAccounts;
    }

    public void setSavingAccounts(List<SavingAccount> savingAccounts) {
        this.savingAccounts = savingAccounts;
    }


    //override the toString method to return a string with all the attributes
    @Override
    public String toString() {
        return "Usuario = " + name + " " + lastName
                + ", Identificacion del usuario = " + idUser + " "
                + "Email = " + email + " "
                + "Telefono = " + phoneNumber + " "
                + "Cuentas de Inversion = " + investmentAccounts + " "
                + "Cuentas de Ahorro = " + savingAccounts;
    }
}
