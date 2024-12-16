package com.example.demo.service.impl;

import com.example.demo.entity.AirplaneEntity;
import com.example.demo.repositories.AirplaneRepository;
import com.example.demo.service.AirplaneService;

public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public AirplaneEntity save(AirplaneEntity airplaneEntity) {
        return airplaneRepository.save(airplaneEntity);
    }

    @Override
    public AirplaneEntity findById(Long id) {
        return airplaneRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Airplane not found"));
    }

    @Override
    public void deleteById(Long id) {
        airplaneRepository.deleteById(id);
    }
}
