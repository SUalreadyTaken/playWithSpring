package com.su.springBoot.service;

import com.su.springBoot.Exceptions.EmployeeNotFoundExeption;
import com.su.springBoot.dao.EmployeeDAO;
import com.su.springBoot.dao.EmployeeRepository;
import com.su.springBoot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee;
        if (employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        } else {
            throw new EmployeeNotFoundExeption("Employee not found with id " + id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    // Version 1 and 2
//    private EmployeeDAO employeeDAO;
//
//    //Qualifies for version 2
//    @Autowired
//    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }
//
//    @Override
//    @Transactional
//    public List<Employee> findAll() {
//        return employeeDAO.findAll();
//    }
//
//    @Override
//    @Transactional
//    public Employee findById(int id) {
//        return employeeDAO.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public void save(Employee employee) {
//        employeeDAO.save(employee);
//    }
//
//    @Override
//    @Transactional
//    public void delete(int id) {
//        employeeDAO.delete(id);
//    }
}
