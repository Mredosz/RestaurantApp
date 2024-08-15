package com.example.backend.account.user.service;

import com.example.backend.account.user.dto.UserRegisterDto;
import com.example.backend.account.user.entity.UserEntity;
import com.example.backend.account.user.exceptions.classes.EmailIsAlreadyTaken;
import com.example.backend.account.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(UserRegisterDto userRegisterDto) throws EmailIsAlreadyTaken {
        if (userRepository.findUserEntityByEmail(userRegisterDto.email()).isPresent()){
            throw new EmailIsAlreadyTaken();
        }
        var user = mapToEntity(userRegisterDto);
        userRepository.save(user);
    }

    private UserEntity mapToEntity(UserRegisterDto userRegisterDto) {
        var user = new UserEntity();
        user.setEmail(userRegisterDto.email());
        user.setPassword(passwordEncoder.encode(userRegisterDto.password()));
        user.setFirstName(userRegisterDto.firstName());
        user.setLastName(userRegisterDto.lastName());
        user.setDateOfBirthday(userRegisterDto.dateOfBirthday());
        user.setPhoneNumber(userRegisterDto.phoneNumber());
        return user;
    }
}
