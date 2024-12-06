package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "airplanes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "ready_to_fly")
    private boolean readToFly;



}
