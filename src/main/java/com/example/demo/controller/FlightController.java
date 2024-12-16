package com.example.demo.controller;

import com.example.demo.dto.flightdtos.FlightDtoAdd;
import com.example.demo.dto.flightdtos.FlightResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(name = "/flight")
@Tag(name = "Контроллер для получения инфомации на рейсах")
public class FlightController {

    @Operation(
            summary = "Получение всех рейсов в системе",
            description = "Возвращает лист рейсов",
            responses ={
                    @ApiResponse(responseCode = "404",
                            description = "Ещё не сделан")
            }
    )
    @GetMapping(name = "/getAll")
    public List<FlightResponseDto> getAllFlight() {
        return Collections.emptyList();
    }

    @Operation(
            summary = "Получает лист рейсов по фильтру",
            responses ={
                    @ApiResponse(responseCode = "404",
                    description = "Ещё не сделан")
            }
    )
    @GetMapping(value = "/getByfilter")
    public List<FlightResponseDto> getFlightByFilter(
            @RequestParam String flightNumber,
            @RequestParam String flightDateDeparture,
            @RequestParam String flightDateArrival,
            @RequestParam String status,
            @RequestParam String placeOfDeparture,
            @RequestParam String placeOfArrival
    ){
    return Collections.emptyList();
    }

    @Operation(
            summary = "Добавить новый рейс",
            description = "Отправляется FlightDtoAdd в котором нужно указывать с какого аиропорта прилетают с помощью " +
                    "id(таким же методом и куда улетают) ",
            responses ={
                    @ApiResponse(responseCode = "404",
                            description = "Ещё не сделан")
            }
    )
    @PostMapping(value = "/add-flight")
    public FlightResponseDto addFlight(@RequestBody FlightDtoAdd flightDtoAdd){
        return null;
    }
}
