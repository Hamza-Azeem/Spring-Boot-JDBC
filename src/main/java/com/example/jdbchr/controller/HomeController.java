package com.example.jdbchr.controller;

import com.example.jdbchr.models.Employee;
import com.example.jdbchr.repository.EmployeeRepo;
import com.example.jdbchr.repository.impl.EmployeeJDBCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HomeController {

    EmployeeRepo employeeRepo;
    @Autowired
    HomeController( EmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    @GetMapping("/count")
    public int countOfEmployee()
    {
        return employeeRepo.count();
    }
    @GetMapping("")
    public List<Employee> findAll()
    {
        return employeeRepo.findAll();
    }
    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable("id") long id)
    {
        return employeeRepo.findById(id);
    }
}
