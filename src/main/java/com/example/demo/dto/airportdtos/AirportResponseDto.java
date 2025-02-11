package com.example.demo.dto.airportdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportResponseDto {
    private Long id;
    private String iata_code;
    private String location;
}
