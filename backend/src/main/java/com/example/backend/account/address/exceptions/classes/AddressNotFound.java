package com.example.backend.account.address.exceptions.classes;

public class AddressNotFound extends RuntimeException {
    public AddressNotFound() {
        super("Address not found.");
    }
}
