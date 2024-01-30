package com.example.jdbchr.repository;

import com.example.jdbchr.models.Employee;

import java.util.List;

public interface EmployeeRepo {
    int count();
    Employee findById(long id);
    List<Employee> findAll();
    List<Employee> findByNameAndSalary(String name, String salary);
    int insert(Employee employee);
    int update(Employee employee);
    int delete(long id);
}
