package com.su.springBoot.service;

import com.su.springBoot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);


}
