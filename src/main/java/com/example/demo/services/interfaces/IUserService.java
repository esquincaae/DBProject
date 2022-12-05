package com.example.demo.services.interfaces;

import java.util.List;
import com.example.demo.controllers.dto.requests.UserRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.controllers.dto.responses.UserResponse;

public interface IUserService {
    
    BaseResponse get(Long id);

    BaseResponse list();

    BaseResponse delete(Long id);

    BaseResponse create(UserRequest request);

    BaseResponse update(Long id, UserRequest request);
}
