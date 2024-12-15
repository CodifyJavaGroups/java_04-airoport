package com.example.demo.dto.airplanes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplanesResponseDto {
    private Long id;
    private String model;
    private String manufacturer;
    private Integer capacity;
    private Boolean ready_to_fly;
}
