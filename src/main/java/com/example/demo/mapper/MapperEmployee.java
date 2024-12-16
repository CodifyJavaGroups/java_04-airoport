package com.example.demo.mapper;

import com.example.demo.dto.employeesdtos.EmployeesResponseDto;
import com.example.demo.entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public class MapperEmployee {
    public static EmployeesResponseDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeesResponseDto employeesResponseDto = new EmployeesResponseDto();
        employeesResponseDto.setId(employeeEntity.getId());
        employeesResponseDto.setPosition(employeeEntity.getPosition());
        employeesResponseDto.setSalary(employeeEntity.getSalary());
        employeesResponseDto.setIdUser(employeeEntity.getUser().getId());
        return employeesResponseDto;
    }
    public static List<EmployeesResponseDto> entitiesToDtos(List<EmployeeEntity> employeeEntities) {
        List<EmployeesResponseDto> employeesResponseDtos = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            employeesResponseDtos.add(entityToDto(employeeEntity));
        }
        return employeesResponseDtos;
    }

}
