package com.companysebasth.ject_bank.models;

public class Supervisor extends Employed {
    private String department;
    private String officeLocation;

    // create a constructor for Supervisor
    public Supervisor(String name, String lastName, Long idEmployed, String email, Long phoneNumber, String position, String hireDate, double salary, String department, String officeLocation) {
        super(name, lastName, idEmployed, email, phoneNumber, position, hireDate, salary);
        this.department = department;
        this.officeLocation = officeLocation;
    }

    // Create a default constructor for Supervisor
    public Supervisor() {
    }

    // Create getters and setters for all attributes
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }
}
