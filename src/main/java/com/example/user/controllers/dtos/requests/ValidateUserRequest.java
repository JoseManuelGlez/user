package com.example.user.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidateUserRequest {
    private String email;

    private String password;
}
