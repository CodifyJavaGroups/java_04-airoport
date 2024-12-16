package com.example.demo.mapper;

import com.example.demo.dto.employeesdtos.EmployeesResponseDto;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.PassportEntity;

public class EmployeeEntityToDto {
    public static EmployeesResponseDto employeeEntityToDto(EmployeeEntity employeeEntity) {
        EmployeesResponseDto employeesResponseDto = new EmployeesResponseDto();
        employeesResponseDto.setId(employeeEntity.getId());
        employeesResponseDto.setPosition(employeeEntity.getPosition());
        employeesResponseDto.setSalary(employeeEntity.getSalary());
        String employee = employeeEntity.getUser().getPassports().stream().findFirst().map(PassportEntity::getFirstName).orElse("No name found");
        employeesResponseDto.setFirstName(employee);
        return employeesResponseDto;

    }
}
