package com.example.backend.account.user.service;

import com.example.backend.account.user.entity.UserEntity;
import com.example.backend.account.user.exceptions.classes.UserNotFound;
import com.example.backend.account.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void deleteUserById(Long id) throws UserNotFound{
        var user = userRepository
                .findById(id)
                .orElseThrow(UserNotFound::new);
       userRepository.delete(user);
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }
}
