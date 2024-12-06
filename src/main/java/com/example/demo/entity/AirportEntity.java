package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "airports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iata_code")
    private String iataCode;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "placeOfDepature")
    private List<FlightEntity> departuresForFlight;

    @OneToMany(mappedBy = "placeOfArrival")
    private List<FlightEntity> arrivalsForFlight;



}
