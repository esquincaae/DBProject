package com.example.demo.services.interfaces;

import java.util.List;
import com.example.demo.controllers.dto.requests.UserRequest;
import com.example.demo.controllers.dto.responses.UserResponse;

public interface IUserService {
    
    UserResponse get(Long id);

    List<UserResponse> list();

    void delete(Long id);

    UserResponse create(UserRequest request);

    void update(Long id, UserRequest request);
}
