package com.example.demo.dto.tickets;

import com.example.demo.dto.flightdtos.FlightResponseDto;
import com.example.demo.dto.passengersdtos.PassengerDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketsResponseDto {
    private Long id;
    private String class_of_service;
    private String seat_number;
    private PassengerDtoResponse passengerDtoResponse;
    private FlightResponseDto flightResponseDto;
}
