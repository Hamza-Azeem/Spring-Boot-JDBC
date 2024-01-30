package com.example.jdbchr;

import com.example.jdbchr.models.Employee;
import com.example.jdbchr.repository.impl.EmployeeJDBCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppStartup implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeJDBCImpl employeeJDBC;
    @Override
    public void run(String... args) throws Exception {
        if(employeeJDBC.count() == 0)
        {
            employeeJDBC.insert(new Employee(1L, "Hamzawy", "2314152"));
            employeeJDBC.insert(new Employee(2L, "Mohamed", "32451"));
            employeeJDBC.insert(new Employee(3L, "Amr", "5000"));
        }
    }
}
