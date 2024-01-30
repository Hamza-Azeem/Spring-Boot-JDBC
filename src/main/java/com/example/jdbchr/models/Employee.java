package com.example.jdbchr.models;

public class Employee {
    private Long id;
    private String name;
    private String salary;
    public Employee(){};
    public Employee(Long id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getSalary() {
        return salary;
    }

    public void setSalary(String  salary) {
        this.salary = salary;
    }
}
