package com.example.demo.service.impl;

import com.example.demo.dto.userdtos.UserManipulationDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.RegisterUnsuccessException;
import com.example.demo.mapper.UserRegisterDtoMapperToUserEntity;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    public UserEntity createUser(@Valid UserEntity user) throws RegisterUnsuccessException {





        return userRepository.save(user);
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

    // TODO: Надо переделывать
//    public UserEntity updateUser(UserEntity userRegisterDto) {
//        if (userRegisterDto == null) {
//            throw new IllegalArgumentException("Некорректный запрос");
//        }
//
//        if (StringUtils.isEmpty(userRegisterDto.getLogin()) ||
//                StringUtils.isEmpty(userRegisterDto.getPassword()) ||
//                StringUtils.isEmpty(userRegisterDto.getFirstName()) ||
//                StringUtils.isEmpty(userRegisterDto.getLastName())) {
//            throw new IllegalArgumentException("Параметры не могут быть пустыми");
//        }
//
//
//        if (!userRegisterDto.getLogin().matches("[a-z0-9]+")) {
//            throw new IllegalArgumentException("Логин должен содержать только маленькие буквы и цифры");
//        }
//
//
//        UserEntity user = userRepository.findByLogin(userRegisterDto.getLogin());
//        if (user == null) {
//            throw new IllegalArgumentException("Пользователь с логином \"" + userRegisterDto.getLogin() + "\" не был найден");
//        }
//
//        user = UserRegisterDtoMapperToUserEntity.toEntity(userRegisterDto);
//        user.setId(user.getId());
//        user = userRepository.save(user);
//        return user;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }
}
