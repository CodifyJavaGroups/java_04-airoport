package com.example.demo.entity;

import com.example.demo.enums.StatusOfFlightEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private StatusOfFlightEntity status;

    @ManyToOne
    @JoinColumn(name = "place_of_departure")
    private AirportEntity placeOfDeparture;

    @ManyToOne
    @JoinColumn(name = "place_of_arrival")
    private AirportEntity placeOfArrival;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;




}
