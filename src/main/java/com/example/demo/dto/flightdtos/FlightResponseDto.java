package com.example.demo.dto.flightdtos;

import com.example.demo.dto.airportdtos.AirportResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponseDto {
    private Long id;
    private String status;
    private AirportResponseDto place_of_departure;
    private AirportResponseDto place_of_arrival;
    private LocalDate departure_time;
    private LocalDate arrival_time;
}
