package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.AuthenticationRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;

public interface IAuthService {
    BaseResponse authenticate(AuthenticationRequest request);
}
