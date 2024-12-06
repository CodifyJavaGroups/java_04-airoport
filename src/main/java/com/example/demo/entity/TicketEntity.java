package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_of_service")
    private String classOfService;

    @Column(name = "seat_number")
    private String seatNumber;

    @OneToOne(mappedBy = "ticket")
    private PassengerEntity passenger;

}
