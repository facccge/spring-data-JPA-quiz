package com.example.employee.entity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Company implements Serializable {
    private int id;
    private String companyName;
    private int employeesNumber;

    public Company() {
    }

    public Company(int id, String companyName, int employeesNumber) {
        this.id = id;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }
}
