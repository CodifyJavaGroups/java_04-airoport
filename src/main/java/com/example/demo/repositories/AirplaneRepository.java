package com.example.demo.repositories;

import com.example.demo.entity.AirplaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<AirplaneEntity, Long> {

}
