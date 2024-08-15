package com.example.backend.account.user.exceptions.classes;

public class WrongPassword extends Exception {
    public WrongPassword() {
        super("Wrong password.");
    }
}
