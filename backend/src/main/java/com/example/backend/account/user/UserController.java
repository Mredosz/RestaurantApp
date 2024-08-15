package com.example.backend.account.user;

import com.example.backend.account.user.entity.UserEntity;
import com.example.backend.account.user.exceptions.classes.UserNotFound;
import com.example.backend.account.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //204 or 404
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws UserNotFound {
        userService.deleteUserById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    //200
    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAll());
    }
}
