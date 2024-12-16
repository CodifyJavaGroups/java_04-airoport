package com.example.demo.service;

import com.example.demo.entity.AirplaneEntity;

public interface AirplaneService {
    AirplaneEntity save(AirplaneEntity airplaneEntity);
    AirplaneEntity findById(Long id);
    void deleteById(Long id);
}
