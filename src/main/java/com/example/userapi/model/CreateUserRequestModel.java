package com.example.userapi.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserRequestModel {
    @NotNull
    @Size(min = 2)
    private String name;
    @NotNull @Email
    private String email;
    @NotNull
    private String userId;
    @NotNull
    @Size(min = 2, max = 16)
    private String password;

}
