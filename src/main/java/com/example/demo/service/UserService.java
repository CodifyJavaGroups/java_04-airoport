package com.example.demo.service;

import com.example.demo.dto.userdtos.UserManipulationDto;
import com.example.demo.dto.userdtos.UserRegisterDto;
import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long Id);
    UserEntity getByLogin(String login);
    UserEntity createUser(UserRegisterDto userRegisterDto);
    void deleteUserById(Long Id);
    UserEntity updateUser(UserRegisterDto userRegisterDto);
    void deleteUser(UserManipulationDto userDeleteDto);
}
