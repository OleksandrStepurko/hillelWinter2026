package com.app.mapper;

import com.app.dto.UserDetailsResponse;
import com.app.dto.UserRequest;
import com.app.dto.UserResponse;
import com.app.entity.User;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User mapToUser(UserRequest request){
        return User.builder()
            .id(UUID.randomUUID())
            .name(request.name())
            .phone(request.phone())
            .email(request.email())
            .build();
    }

    public UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .build();
    }

    public UserDetailsResponse mapToUserDetailsResponse(User user){
        return UserDetailsResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .phone(user.getPhone())
            .email(user.getEmail())
            .build();
    }
}
