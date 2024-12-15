package com.example.demo.dto.passengersdtos;

import com.example.demo.dto.flightdtos.FlightResponseDto;
import com.example.demo.dto.passportsdtos.PassportResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDtoResponse {
    private Long id;
    private PassportResponseDto passportResponseDto;
    private FlightResponseDto flightResponseDto;
}
