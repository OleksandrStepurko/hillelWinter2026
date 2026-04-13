package com.app.controller;

import com.app.dto.UserDetailsResponse;
import com.app.dto.UserRequest;
import com.app.dto.UserResponse;
import com.app.entity.User;
import com.app.mapper.UserMapper;
import com.app.service.UserService;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper mapper;
    private final UserService service;

    @PostMapping("")
    public UUID createUser(@RequestBody UserRequest userRequest){
        return service.addUser(mapper.mapToUser(userRequest));
    }

    @GetMapping("")
    public List<UserResponse> getAllUser(){
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public UserDetailsResponse getAllUser(@PathVariable UUID id){
        return service.getUserDetails(id);
    }

    @GetMapping("/find")
    public List<UserResponse> getAllUserByString(@RequestParam(required = true)
    @Size (min = 3, max = 10, message = "Search length form 3 to 10") String str){
        return service.getUsersByStr(str);
    }
}
