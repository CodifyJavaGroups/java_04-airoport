package com.example.demo.dto.flightdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDtoAdd {
    private String status;
    private Long placeOfDepartureId;
    private Long placeOfArrivalId;
    private LocalDate departure_time;
    private LocalDate arrival_time;
}
