package com.example.backend.security;

import com.example.backend.account.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class RestaurantUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserEntityByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist " + username));
        return new User(user.getFirstName() + " " + user.getLastName(), user.getPassword(), new ArrayList<>());
    }
}
