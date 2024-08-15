package com.example.backend.account.user.exceptions.classes;

public class EmailIsAlreadyTaken extends Exception {
  public EmailIsAlreadyTaken() {
    super("Email is already taken.");
  }
}
