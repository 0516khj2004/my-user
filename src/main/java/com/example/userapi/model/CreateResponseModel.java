package com.example.userapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateResponseModel {
    private String name;
    private String email;
    private String userId;
}
