package com.example.demo.repositories;

import com.example.demo.entity.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportsRepository extends JpaRepository<PassportEntity,Long> {
}
