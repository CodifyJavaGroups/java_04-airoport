package com.example.demo.dto.passportsdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportResponseDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String passport_id;
    private LocalDate birth_date;
    private LocalDate death_date;


}
