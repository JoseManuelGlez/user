package com.example.user.controllers.dtos;

import com.example.user.controllers.dtos.requests.CreateUserRequest;
import com.example.user.controllers.dtos.requests.ValidateUserRequest;
import com.example.user.controllers.dtos.responses.BaseResponse;
import com.example.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class UserController {
    @Autowired
    private IUserService service;

    @PostMapping()
    public BaseResponse create(@RequestBody CreateUserRequest request) {
        return service.create(request);
    }

    @PostMapping("validate")
    public BaseResponse validate(@RequestBody ValidateUserRequest request){
        return service.validate(request);
    }
}
