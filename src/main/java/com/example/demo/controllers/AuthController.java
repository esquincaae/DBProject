package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.AuthenticationRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.services.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private IAuthService service;

    @PostMapping("token")
    public ResponseEntity<BaseResponse> authentication(@RequestBody @Valid AuthenticationRequest request) {
        BaseResponse response = service.authenticate(request);

        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
