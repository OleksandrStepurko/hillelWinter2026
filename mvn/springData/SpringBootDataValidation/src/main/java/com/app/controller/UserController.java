package com.app.controller;

import com.app.dto.UserDto;
import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public UUID createUser(@RequestBody @Valid UserDto user) {

        UserEntity userEntity = new UserEntity()
            .setUsername(user.getUsername())
            .setPassword(user.getPassword())
            .setEmail(user.getEmail())
            .setPhoneNumber(user.getPhoneNumber());

        return userRepository.save(userEntity).getId();
    }

    @GetMapping
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userRepository.deleteById(id);
    }

    @PutMapping
    public UserEntity deleteUser(@RequestBody UserEntity entity) {
        return userRepository.save(entity);
    }

}
