package com.example.demo.service;

import com.example.demo.dto.userdtos.UserManipulationDto;
import com.example.demo.dto.userdtos.UserRegisterDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserRegisterDtoMapperToUserEntity;
import com.example.demo.repositories.UserRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new EntityNotFoundException("Пользователи не были найдены");
        }
        return users;
    }

    public UserEntity getUserById(Long id) {
        if (id == null || id < 1) {
            throw new IllegalArgumentException("Пользователя с ID:" + id + " не может быть в системе");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с ID:" + id + " не был найден"));
    }

    public UserEntity getByLogin(String login) {
        if (StringUtils.isEmpty(login)) {
            throw new IllegalArgumentException("Неккоректный логин");
        }
        UserEntity user = userRepository.findByLogin(login);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь с логином \"" + login + "\" не был найден");
        }
        return user;
    }

    public UserEntity createUser(UserRegisterDto userRegisterDto) {
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
        UserEntity user = UserRegisterDtoMapperToUserEntity.toEntity(userRegisterDto);
        user = userRepository.save(user);
        return user;
    }

    public void deleteUserById(Long id) {
        if (id == null || id < 1) {
            throw new IllegalArgumentException("Пользователь с ID:" + id + " не может быть в системе");
        }
        userRepository.deleteById(id);
    }


    public void deleteUser(UserManipulationDto userDeleteDto) {
        if (userDeleteDto == null) {
            throw new IllegalArgumentException("Неккоректный запрос");
        }
        if (StringUtils.isEmpty(userDeleteDto.getLogin()) || StringUtils.isEmpty(userDeleteDto.getPassword())) {
            throw new IllegalArgumentException("Логин или пароль не может быть пустым");
        }
        userRepository.deleteByLogin(userDeleteDto.getLogin());
    }

    public UserEntity updateUser(UserRegisterDto userRegisterDto) {
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

        user = UserRegisterDtoMapperToUserEntity.toEntity(userRegisterDto);
        user.setId(user.getId());
        user = userRepository.save(user);
        return user;
    }

}
