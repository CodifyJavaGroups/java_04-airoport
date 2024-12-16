package com.example.demo.service;

import com.example.demo.entity.RoleEntity;

import javax.management.relation.Role;

public interface RoleService {
    void addRole(RoleEntity role);
    RoleEntity getRole(String roleName);
    RoleEntity getUserRole();
    void deleteRole(String roleName);

}
