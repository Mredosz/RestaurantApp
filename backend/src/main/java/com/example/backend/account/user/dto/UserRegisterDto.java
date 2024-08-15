package com.example.backend.account.user.dto;

import java.time.LocalDate;

public record UserRegisterDto(String firstName, String lastName, String email, String password, String phoneNumber, LocalDate dateOfBirthday) {
}
