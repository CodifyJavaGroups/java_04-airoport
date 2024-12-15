package com.example.demo.dto.tasks_of_employeesdtos;

import com.example.demo.dto.employeesdtos.EmployeesResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks_of_Employees {
    private Long Id;
    private String task;
    private EmployeesResponseDto employeesResponseDto;
}
