package com.example.userapi.service;

import com.example.userapi.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface Userservice extends UserDetailsService {

    UserDto createUser(UserDto userDetails);

    UserDto getUserDetailsByEmail(String email);

    UserDto getUserByUserId(String userId);
}
