package com.example.backend.account.user.service;

import com.example.backend.account.user.dto.UserLoginDto;
import com.example.backend.account.user.exceptions.classes.WrongEmail;
import com.example.backend.account.user.exceptions.classes.WrongPassword;
import com.example.backend.account.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void login(UserLoginDto userLoginDto) throws WrongEmail, WrongPassword {
        var user = userRepository.findUserEntityByEmail(userLoginDto.email())
                .orElseThrow(WrongEmail::new);

        if (!passwordEncoder.matches(userLoginDto.password(), user.getPassword())){
            throw new WrongPassword();
        }
    }
}
