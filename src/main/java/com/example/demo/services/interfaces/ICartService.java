package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.CartRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;

public interface ICartService {

    BaseResponse list(Long id);

    BaseResponse delete(Long id);

    BaseResponse create(CartRequest request);

    BaseResponse update(Long id, CartRequest request);

}
