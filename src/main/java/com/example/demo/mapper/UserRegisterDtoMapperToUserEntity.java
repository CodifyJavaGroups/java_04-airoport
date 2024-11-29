package com.example.demo.mapper;

import com.example.demo.dto.userdtos.UserRegisterDto;
import com.example.demo.entity.UserEntity;

public class UserRegisterDtoMapperToUserEntity {
    public static UserEntity toEntity(UserRegisterDto userRegisterDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userRegisterDto.getFirstName());
        userEntity.setLastName(userRegisterDto.getLastName());
        userEntity.setLogin(userRegisterDto.getLogin());
        userEntity.setPassword(userRegisterDto.getPassword());
        return userEntity;
    }
}
