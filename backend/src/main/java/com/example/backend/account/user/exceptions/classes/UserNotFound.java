package com.example.backend.account.user.exceptions.classes;

public class UserNotFound extends RuntimeException {
    public UserNotFound() {
        super("User not found");
    }
}
