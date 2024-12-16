package com.example.demo.dto.employeesdtos;

import com.example.demo.dto.userdtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateDto {
    private String position;
    private BigDecimal salary;
    private UserDto userRegisterDto;
}
