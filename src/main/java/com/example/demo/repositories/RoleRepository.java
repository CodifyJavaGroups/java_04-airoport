package com.example.demo.repositories;

import com.example.demo.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    @Query(value = "select r from RoleEntity r where r.title = 'ROLE_USER'")
    RoleEntity findUserRole();
    RoleEntity findByTitle(String role);
    void deleteByTitle(String role);
    void deleteById(Long id);
}
