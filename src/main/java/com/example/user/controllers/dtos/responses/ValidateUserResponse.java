package com.example.user.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidateUserResponse {
    private Long id;
    private String email;
    private String password;
    private String fullName;
}
