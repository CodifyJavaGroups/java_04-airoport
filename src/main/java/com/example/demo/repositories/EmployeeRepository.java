package com.example.demo.repositories;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    boolean existsByUser(UserEntity user);
}
