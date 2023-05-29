package com.codegym.model;

public class Employee {
    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private double salary;
    private String department;

    public Employee() {
    }

    public Employee(String id, String name, String email, String address, String phoneNumber, double salary, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name,String email, String address, String phoneNumber, double salary, String department) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
