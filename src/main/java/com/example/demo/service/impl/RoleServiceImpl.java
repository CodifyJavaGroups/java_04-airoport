package com.example.demo.service.impl;

import com.example.demo.entity.RoleEntity;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.relation.Role;
import java.util.Objects;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public void addRole(RoleEntity role) {
        if (Objects.isNull(role) || Objects.isNull(role.getTitle())) {
            throw new IllegalArgumentException("Параметры не могут быть пустыми");
        }
        roleRepository.save(role);
    }

    @Override
    public RoleEntity getRole(String roleName) {
        return null;
    }

    @Override
    public RoleEntity getUserRole() {
        return null;
    }

    @Override
    public void deleteRole(String roleName) {

    }
}
