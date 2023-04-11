package com.example.user.services;

import com.example.user.controllers.dtos.requests.CreateUserRequest;
import com.example.user.controllers.dtos.requests.ValidateUserRequest;
import com.example.user.controllers.dtos.responses.BaseResponse;
import com.example.user.controllers.dtos.responses.ValidateUserResponse;
import com.example.user.entities.User;
import com.example.user.entities.projections.IUserProjection;
import com.example.user.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
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

    @Override
    public BaseResponse validate(ValidateUserRequest request) {
        IUserProjection user = from(request);

            return BaseResponse.builder()
                    .data(from(user))
                    .message("User validated correctly")
                    .success(Boolean.TRUE)
                    .httpStatus(HttpStatus.CREATED).build();
    }

    private ValidateUserResponse from(IUserProjection projection) {
        ValidateUserResponse response = new ValidateUserResponse();
        response.setId(projection.getUserId());
        response.setFullName(projection.getUserFullName());
        response.setEmail(projection.getUserEmail());
        response.setPassword(projection.getUserPassword());
        return response;
    }

    private IUserProjection from(ValidateUserRequest request){
        return repository.findUserByEmailAndPassword(request.getEmail(), request.getPassword());
    }

    private User from(CreateUserRequest request){
        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }
}
