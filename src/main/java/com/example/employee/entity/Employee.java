package com.example.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Entity
public class Employee{
    @Id
    private long id;
    private String name;
    private int age;
    private String gender;
    private int companyId;
    private int salary;

    public Employee(){}

    public Employee(int id, String name, int age, String gender, int companyId, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.companyId = companyId;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getCompanyId() {
        return companyId;
    }

    public int getSalary() {
        return salary;
    }
}
