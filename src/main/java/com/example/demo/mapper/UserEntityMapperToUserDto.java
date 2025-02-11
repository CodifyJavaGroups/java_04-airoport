package com.example.demo.mapper;

import com.example.demo.dto.userdtos.UserDto;
import com.example.demo.entity.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEntityMapperToUserDto {
    public static UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getPassports().get(0).getFirstName());
        userDto.setLastName(userEntity.getPassports().get(0).getLastName());
        userDto.setLogin(userEntity.getLogin());
        return userDto;
    }
}
