package com.example.assignment_lab6;

public class Employee {
    private String name;
    private String title;
    private String phoneNo;
    private String email;
    private Department department;

    public Employee(String name, String title, String phoneNo, String email, Department department) {
        this.name = name;
        this.title = title;
        this.phoneNo = phoneNo;
        this.email = email;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
