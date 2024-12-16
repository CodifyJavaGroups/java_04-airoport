package com.example.demo.repositories;

import com.example.demo.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengersRepository extends JpaRepository<PassengerEntity,Long> {
}
