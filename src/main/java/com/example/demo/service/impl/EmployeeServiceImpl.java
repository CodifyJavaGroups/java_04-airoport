package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.EmployeeService;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public EmployeeEntity save(String position, BigDecimal salary, String login) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position must not be null or empty");
        }
        if (salary == null || salary.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salary must be a positive value");
        }
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login must not be null or empty");
        }

        UserEntity user = userRepository.findByLogin(login);
        if (user == null) {
            throw new IllegalArgumentException("User not found for login: " + login);
        }

        if (employeeRepository.existsByUser(user)) {
            throw new IllegalStateException("Employee already exists for the specified user");
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPosition(position);
        employeeEntity.setSalary(salary);
        employeeEntity.setUser(user);
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
