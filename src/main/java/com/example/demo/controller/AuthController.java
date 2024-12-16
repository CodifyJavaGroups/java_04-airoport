package com.example.demo.controller;

import com.example.demo.dto.userdtos.UserDto;
import com.example.demo.entity.PassportEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.RegisterUnsuccessException;
import com.example.demo.mapper.UserEntityMapperToUserDto;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
    private final UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(value = "/register")
    public ResponseEntity<UserDto> register(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String passportId,
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam LocalDate dateOfBirth
            ) {
        UserEntity user = new UserEntity();
        PassportEntity passport = new PassportEntity();

        passport.setFirstName(firstname);
        passport.setLastName(lastname);
        passport.setUserPassportId(passportId);
        passport.setDateOfBirth(dateOfBirth);
        user.setLogin(login);
        user.setPassword(password);
        user.getPassports().add(passport);
        try {
            return ResponseEntity.ok(UserEntityMapperToUserDto.toDto(userService.createUser(user)));
        }
        catch (RegisterUnsuccessException e) {
            e.getMessage();
        }
        return null;
    }
}
