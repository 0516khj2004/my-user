package com.example.userapi.shared;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String userId;

    private String encryptedPassword;
}
