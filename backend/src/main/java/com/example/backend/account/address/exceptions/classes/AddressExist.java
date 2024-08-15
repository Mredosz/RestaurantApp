package com.example.backend.account.address.exceptions.classes;

public class AddressExist extends RuntimeException {
    public AddressExist() {
        super("Address already exist.");
    }
}
