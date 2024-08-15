package com.example.backend.account;

import com.example.backend.account.user.dto.UserLoginDto;
import com.example.backend.account.user.dto.UserRegisterDto;
import com.example.backend.account.user.exceptions.classes.EmailIsAlreadyTaken;
import com.example.backend.account.user.exceptions.classes.WrongEmail;
import com.example.backend.account.user.exceptions.classes.WrongPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    //200 or 401
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserLoginDto userLoginDto) throws WrongEmail, WrongPassword {
        accountService.login(userLoginDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    //201 or 409
    @PostMapping("/registration")
    public ResponseEntity<Void> register(@RequestBody UserRegisterDto userRegisterDto) throws EmailIsAlreadyTaken {
        accountService.register(userRegisterDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
