package com.example.demo.service;

import com.example.demo.entity.PassportEntity;
import com.example.demo.exceptions.PassportIsInvalidException;

public interface PassportService {
    boolean validatePassport(PassportEntity passport) throws PassportIsInvalidException;
}
