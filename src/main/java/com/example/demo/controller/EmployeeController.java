package com.example.demo.controller;

import com.example.demo.dto.employeesdtos.EmployeeCreateDto;
import com.example.demo.dto.employeesdtos.EmployeeResumeDto;
import com.example.demo.dto.employeesdtos.EmployeesResponseDto;
import com.example.demo.dto.passportsdtos.PassportCreateDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(name = "/employee")
public class EmployeeController {

    @GetMapping(name = "get-all")
    public List<EmployeesResponseDto> getAll(){
        return Collections.emptyList();
    }

    @PostMapping(name = "send-resume")
    public Boolean sendResumeEmployee(
            @RequestBody EmployeeResumeDto employeeResumeDto,
            @RequestParam String aboutMyself
    ){
        return false;
    }

    @PostMapping(name = "add-employee")
    public EmployeesResponseDto addEmployee(@RequestParam Long id, @RequestParam Long idRole){
        return null;
    }


    @DeleteMapping(name = "/dismiss")
    public Boolean dismissEmployee(
            @RequestParam Long employeeId,
            @RequestParam String reasonForDismissal,
            @RequestParam Long idRole
    ){
        return false;
    }

    @GetMapping(name = "/filter")
    public List<EmployeesResponseDto> filterEmployees(
            @RequestParam String position,
            @RequestParam BigDecimal salary,
            @RequestParam String lastName
    ){
    return Collections.emptyList();
    }

    @PutMapping(name = "/update")
    public EmployeesResponseDto updateEmployee(
            @RequestParam Long employeeId,
            @RequestParam String position,
            @RequestParam BigDecimal salary,
            @RequestBody PassportCreateDto passportCreateDto
            ){
        return new EmployeesResponseDto();
    }
}
