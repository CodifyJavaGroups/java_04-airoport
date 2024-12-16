package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;

public class UserRegisterDtoMapperToUserEntity {
    public static UserEntity toEntity(UserRegisterDto userRegisterDto){
        UserEntity userEntity = new UserEntity();
        userEntity.getPassports().get(0).setFirstName(userRegisterDto.getFirstName());
        userEntity.getPassports().get(0).setLastName(userRegisterDto.getLastName());
        userEntity.setLogin(userRegisterDto.getLogin());
        userEntity.setPassword(userRegisterDto.getPassword());
        return userEntity;
    }
}
