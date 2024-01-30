package com.example.jdbchr.repository.impl;

import com.example.jdbchr.mapper.EmployeeRowMapper;
import com.example.jdbchr.models.Employee;
import com.example.jdbchr.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@Qualifier("employeeJDBCImpl")
public class EmployeeJDBCImpl implements EmployeeRepo {
    private JdbcTemplate jdbcTemplate ;
    @Autowired
    EmployeeJDBCImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }
    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
    }

    @Override
    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select id, name, salary from employee where id=?",
                new Object[]{id}, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select id, name, salary from employee",
                new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, String salary) {
        return null;
    }

    @Override
    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employee(id, name, salary) values(?,?,?)",
                new Object[]{employee.getId(), employee.getName(), employee.getSalary()});
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update employee set name=?, salary=? where id=?",
                new Object[]{employee.getName(), employee.getSalary(), employee.getId()});
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("delete from employee where id = ?", new Object[]{id});
    }
}
