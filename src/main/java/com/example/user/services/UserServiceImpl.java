package com.example.user.services;

import com.example.user.controllers.dtos.requests.CreateUserRequest;
import com.example.user.controllers.dtos.responses.BaseResponse;
import com.example.user.controllers.dtos.responses.CreateUserResponse;
import com.example.user.entities.User;
import com.example.user.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRepository repository;

    @Override
    public BaseResponse create(CreateUserRequest request) {
        User user = repository.save(from(request));

        return BaseResponse.builder()
                .data(user)
                .message("User created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    private User from(CreateUserRequest request){
        User user = new User();

        return user;
    }

    private CreateUserResponse from(User user){
        CreateUserResponse response = new CreateUserResponse();

        response.setId(user.getId());
        return response;
    }
}
