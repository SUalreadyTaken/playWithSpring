package com.su.springBoot.dao;

import com.su.springBoot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);

}
