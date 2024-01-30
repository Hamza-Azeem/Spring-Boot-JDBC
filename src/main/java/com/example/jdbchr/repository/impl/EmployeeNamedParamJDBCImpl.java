package com.example.jdbchr.repository.impl;

import com.example.jdbchr.mapper.EmployeeRowMapper;
import com.example.jdbchr.models.Employee;
import com.example.jdbchr.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("employeeNamedParamJDBCImpl")
public class EmployeeNamedParamJDBCImpl implements EmployeeRepo {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public EmployeeNamedParamJDBCImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int count() {
        return 0;    }

    @Override
    public Employee findById(long id) {
        return namedParameterJdbcTemplate.queryForObject("select id, name, salary from employee where id=:id",
                new MapSqlParameterSource("id", id), new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findAll() {
        return namedParameterJdbcTemplate.query("select id, name, salary from employee",
        new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, String salary) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);
        param.addValue("salary", salary);
        return namedParameterJdbcTemplate.query(
                "select id, name, salary from employee where name=:name, salary=:salary",
                param, new EmployeeRowMapper()
        );
    }

    @Override
    public int insert(Employee employee) {
        return namedParameterJdbcTemplate.update(
                "insert into employee(id, name, salary) values(:id, :name, :salary)",
                new BeanPropertySqlParameterSource(employee)
        );
    }

    @Override
    public int update(Employee employee) {
        return namedParameterJdbcTemplate.update("update employee set name=:name, salary=:salary where id=:id",
                new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public int delete(long id) {
        return namedParameterJdbcTemplate.update("delete employee where id=:id",
                new MapSqlParameterSource("id", id));
    }
}
