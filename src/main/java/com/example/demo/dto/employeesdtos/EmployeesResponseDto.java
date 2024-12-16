package com.example.demo.dto.employeesdtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesResponseDto {
    private Long Id;
    private String position;
    private BigDecimal salary;
    private String firstName;
}
