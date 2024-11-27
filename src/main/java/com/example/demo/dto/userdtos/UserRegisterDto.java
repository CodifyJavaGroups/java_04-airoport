package com.example.demo.dto.userdtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
