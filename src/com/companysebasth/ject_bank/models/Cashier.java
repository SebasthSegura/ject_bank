package com.companysebasth.ject_bank.models;

public class Cashier extends Employed {
    private String assignedBranch;
    private String shift;

    // Constructor for Cashier
    public Cashier(String name, String lastName, Long idEmployed, String email, Long phoneNumber, String position, String hireDate, double salary, String assignedBranch, String shift) {
        super(name, lastName, idEmployed, email, phoneNumber, position, hireDate, salary);
        this.assignedBranch = assignedBranch;
        this.shift = shift;
    }

    // Default constructor
    public Cashier() {
    }

    // Getters and Setters
    public String getAssignedBranch() {
        return assignedBranch;
    }

    public void setAssignedBranch(String assignedBranch) {
        this.assignedBranch = assignedBranch;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public void updateContacInformation(String newEmail, Long newPhoneNumber, String shift) {
        setEmail(newEmail);
        setPhoneNumber(newPhoneNumber);
        setShift(shift);
    }
}