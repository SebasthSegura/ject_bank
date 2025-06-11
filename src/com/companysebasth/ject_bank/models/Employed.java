package com.companysebasth.ject_bank.models;

public class Employed {
    private String name;
    private String lastName;
    private Long idEmployed;
    private String email;
    private int phoneNumber;
    private String position;
    private String hireDate;
    private double salary;

    // create a constructor for Employed
    public Employed(String name, String lastName, Long idEmployed, String email, int phoneNumber, String position, String hireDate, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.idEmployed = idEmployed;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    //create a default constructor for Employed
    public Employed() {
    }

    // Create getters and setters for all attributes
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

    public Long getIdEmployed() {
        return idEmployed;
    }

    public void setIdEmployed(Long idEmployed) {
        this.idEmployed = idEmployed;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
