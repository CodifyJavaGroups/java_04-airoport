package com.example.demo.service.impl;

import com.example.demo.entity.PassportEntity;
import com.example.demo.exceptions.PassportIsInvalidException;
import com.example.demo.service.PassportService;

import java.time.LocalDate;

public class PassportServiceImpl implements PassportService {
    @Override
    public boolean validatePassport(PassportEntity passport) throws PassportIsInvalidException {
        String firstName = passport.getFirstName();
        String lastName = passport.getLastName();
        String userPassportId = passport.getUserPassportId();
        LocalDate dateOfBirth = passport.getDateOfBirth();

        return false;
    }
}
