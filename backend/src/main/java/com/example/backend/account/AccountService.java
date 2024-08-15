package com.example.backend.account;

import com.example.backend.account.user.dto.UserLoginDto;
import com.example.backend.account.user.dto.UserRegisterDto;
import com.example.backend.account.user.exceptions.classes.EmailIsAlreadyTaken;
import com.example.backend.account.user.exceptions.classes.WrongEmail;
import com.example.backend.account.user.exceptions.classes.WrongPassword;
import com.example.backend.account.user.service.UserLoginService;
import com.example.backend.account.user.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserLoginService userLoginService;
    private final UserRegisterService userRegisterService;

    public void register(UserRegisterDto userRegisterDto) throws EmailIsAlreadyTaken {
        userRegisterService.register(userRegisterDto);
    }

    public void login(UserLoginDto userLoginDto) throws WrongEmail, WrongPassword {
        userLoginService.login(userLoginDto);
    }
}
