package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;


import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    EmployeeEntity save(String position, BigDecimal salary, String login);
    EmployeeEntity findById(Long id);
    void deleteById(Long id);
    List<EmployeeEntity> getAllEmployees();
}
