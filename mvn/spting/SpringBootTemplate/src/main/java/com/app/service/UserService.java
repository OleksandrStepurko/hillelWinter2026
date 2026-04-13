package com.app.service;

import com.app.dto.UserDetailsResponse;
import com.app.dto.UserResponse;
import com.app.entity.User;
import com.app.exceptions.UserNorFoundException;
import com.app.mapper.UserMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private List<User> userList = new ArrayList<>();

    public UUID addUser(User user){
        userList.add(user);
        return user.getId();
    }

    public List<UserResponse> getUsers() {
      return userList.stream().map(userMapper::mapToUserResponse).toList();
    }

    public UserDetailsResponse getUserDetails(UUID id) {
         User user = userList.stream().filter(u -> id.equals(u.getId())).findFirst()
             .orElseThrow(() -> new UserNorFoundException(String.format("User id : %s not found", id)));
        return userMapper.mapToUserDetailsResponse(user);
    }

    public List<UserResponse> getUsersByStr(String str) {
        return userList.stream()
            .filter(u -> u.getName().toLowerCase().contains(str.toLowerCase()))
            .map(userMapper::mapToUserResponse).toList();
    }
}
