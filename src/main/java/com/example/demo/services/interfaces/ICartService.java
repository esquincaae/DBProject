package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.CartRequest;
import com.example.demo.controllers.dto.responses.CartResponse;

import java.util.List;

public interface ICartService {

    List<CartResponse> list(Long id);

    void delete(Long id);

    CartResponse create(CartRequest request);

    void update(Long id, CartRequest request);

}
