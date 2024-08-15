package com.example.backend.account.address.exceptions;

import com.example.backend.account.address.exceptions.classes.AddressExist;
import com.example.backend.account.address.exceptions.classes.AddressNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AddressExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AddressNotFound.class)
    protected ResponseEntity<String> addressNotFound(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AddressExist.class)
    protected ResponseEntity<String> addressExist(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
