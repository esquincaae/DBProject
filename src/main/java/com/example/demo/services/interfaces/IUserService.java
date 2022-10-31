package com.example.demo.services.interfaces;

import java.util.List;
import com.example.demo.controllers.dto.requests.CreateUserRequest;
import com.example.demo.controllers.dto.requests.UpdateUserRequest;
import com.example.demo.controllers.dto.responses.GetUserResponse;

public interface IUserService {
    
    GetUserResponse get(Long id);

    List<GetUserResponse> list();

    void delete(Long id);

    GetUserResponse create(CreateUserRequest request);

    GetUserResponse update(Long id, UpdateUserRequest request);
}
