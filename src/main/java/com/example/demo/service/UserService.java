package com.example.demo.service;

import com.example.demo.dto.userdtos.UserDeleteDto;
import com.example.demo.dto.userdtos.UserDto;
import com.example.demo.dto.userdtos.UserRegisterDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserEntityMapperToUserDto;
import com.example.demo.mapper.UserRegisterDtoMapperToUserEntity;
import com.example.demo.repositories.UserRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new EntityNotFoundException("Пользователи не были найдены");
        }
        return users.stream()
                .map(UserEntityMapperToUserDto::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        if (id == null || id < 1) {
            throw new IllegalArgumentException("Пользователя с ID:" + id + " не может быть в системе");
        }
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с ID:" + id + " не был найден"));
        return UserEntityMapperToUserDto.toDto(user);
    }

    public UserDto getByLogin(String login) {
        if (StringUtils.isEmpty(login)) {
            throw new IllegalArgumentException("Неккоректный логин");
        }
        UserEntity user = userRepository.findByLogin(login);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь с логином \"" + login + "\" не был найден");
        }
        return UserEntityMapperToUserDto.toDto(user);
    }

    @Modifying
    @Transactional
    public UserDto createUser(UserRegisterDto userRegisterDto) {
        if (userRegisterDto == null) {
            throw new IllegalArgumentException("Неккоректный запрос");
        }
        if (StringUtils.isEmpty(userRegisterDto.getLogin()) ||
                StringUtils.isEmpty(userRegisterDto.getPassword()) ||
                StringUtils.isEmpty(userRegisterDto.getFirstName()) ||
                StringUtils.isEmpty(userRegisterDto.getLastName())) {
            throw new IllegalArgumentException("Все обязательные поля должны быть заполнены");
        }
        if (!userRegisterDto.getLogin().matches("[a-z0-9]+")) {
            throw new IllegalArgumentException("Логин должен состоять только из строчных букв и цифр");
        }
        if (userRegisterDto.getLogin().length() > 50 || userRegisterDto.getPassword().length() > 50) {
            throw new IllegalArgumentException("Логин и пароль не могут превышать 50 символов");
        }
        UserEntity user = UserRegisterDtoMapperToUserEntity.toDto(userRegisterDto);
        user = userRepository.save(user);
        return UserEntityMapperToUserDto.toDto(user);
    }

    @Modifying
    @Transactional
    public void deleteUserById(Long id) {
        if (id == null || id < 1) {
            throw new IllegalArgumentException("Пользователь с ID:" + id + " не может быть в системе");
        }
        userRepository.deleteById(id);
    }

    public void deleteUserByLogin(String login) {
        if (StringUtils.isEmpty(login)) {
            throw new IllegalArgumentException("Логин не может быть пустым");
        }
        userRepository.deleteByLogin(login);
    }

    public void deleteUser(UserDeleteDto userDeleteDto) {
        if (userDeleteDto == null) {
            throw new IllegalArgumentException("Неккоректный запрос");
        }
        if (StringUtils.isEmpty(userDeleteDto.getLogin()) || StringUtils.isEmpty(userDeleteDto.getPassword())) {
            throw new IllegalArgumentException("Логин или пароль не может быть пустым");
        }
        userRepository.deleteByLogin(userDeleteDto.getLogin());
    }

    @Transactional
    @Modifying
    public UserDto updateUser(UserRegisterDto userRegisterDto) {
        if (userRegisterDto == null) {
            throw new IllegalArgumentException("Некорректный запрос");
        }

        if (StringUtils.isEmpty(userRegisterDto.getLogin()) ||
                StringUtils.isEmpty(userRegisterDto.getPassword()) ||
                StringUtils.isEmpty(userRegisterDto.getFirstName()) ||
                StringUtils.isEmpty(userRegisterDto.getLastName())) {
            throw new IllegalArgumentException("Параметры не могут быть пустыми");
        }


        if (!userRegisterDto.getLogin().matches("[a-z0-9]+")) {
            throw new IllegalArgumentException("Логин должен содержать только маленькие буквы и цифры");
        }


        UserEntity user = userRepository.findByLogin(userRegisterDto.getLogin());
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с логином \"" + userRegisterDto.getLogin() + "\" не был найден");
        }

        user = UserRegisterDtoMapperToUserEntity.toDto(userRegisterDto);
        user.setId(user.getId());
        user = userRepository.save(user);
        return UserEntityMapperToUserDto.toDto(user);
    }

}
