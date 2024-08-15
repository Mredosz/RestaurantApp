package com.example.backend.account.user.exceptions;

import com.example.backend.account.user.exceptions.classes.EmailIsAlreadyTaken;
import com.example.backend.account.user.exceptions.classes.UserNotFound;
import com.example.backend.account.user.exceptions.classes.WrongEmail;
import com.example.backend.account.user.exceptions.classes.WrongPassword;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailIsAlreadyTaken.class)
    protected ResponseEntity<String> emailIsAlreadyTaken(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(WrongEmail.class)
    protected ResponseEntity<String> wrongEmail(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(WrongPassword.class)
    protected ResponseEntity<String> wrongPassword(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFound.class)
    protected ResponseEntity<String> userNotFound(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}