package com.example.demo.controller;

import com.example.demo.dto.userdtos.UserDeleteDto;
import com.example.demo.dto.userdtos.UserDto;
import com.example.demo.dto.userdtos.UserRegisterDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserRegisterDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping(value = "/get-by/id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping(value = "/get-by/login/{login}")
    public ResponseEntity<UserDto> getUserByLogin(@PathVariable String login) {
        return ResponseEntity.ok(userService.getByLogin(login));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserRegisterDto user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping(value = "/delete-by/id/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @DeleteMapping(value = "/delete-by/login/{login}")
    public void deleteUserByLogin(@PathVariable String login) {
        userService.deleteUserByLogin(login);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestBody UserDeleteDto user) {
        userService.deleteUser(user);
    }
}

