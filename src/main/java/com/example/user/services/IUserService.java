package com.example.user.services;

import com.example.user.controllers.dtos.requests.CreateUserRequest;
import com.example.user.controllers.dtos.responses.BaseResponse;

public interface IUserService {
    BaseResponse create(CreateUserRequest request);
}
