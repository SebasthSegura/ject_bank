package com.companysebasth.ject_bank.models;

public class Receptionist extends Employed{
    private String shift;
    private String assignedBranch;

    // Constructor for Receptionist
    public Receptionist(String name, String lastName, Long idEmployed, String email, int phoneNumber, String position, String hireDate, double salary, String shift, String assignedBranch) {
        super(name, lastName, idEmployed, email, phoneNumber, position, hireDate, salary);
        this.shift = shift;
        this.assignedBranch = assignedBranch;
    }

    // Default constructor
    public Receptionist() {
    }

    // Getters and Setters
    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getAssignedBranch() {
        return assignedBranch;
    }

    public void setAssignedBranch(String assignedBranch) {
        this.assignedBranch = assignedBranch;
    }
}
