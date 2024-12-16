package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.RegisterUnsuccessException;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long Id);
    UserEntity getByLogin(String login);
    UserEntity createUser(UserEntity user) throws RegisterUnsuccessException;
    void deleteUserById(Long Id);
    //TODO: Надо переделывать, посмотрим, нужны ли дтошки
//    UserEntity updateUser(UserEntity user);
//    void deleteUser(UserManipulationDto userDeleteDto);
}
