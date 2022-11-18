package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.CreateCarProductRequest;
import com.example.demo.controllers.dto.requests.UpdateCarProductRequest;
import com.example.demo.controllers.dto.responses.GetCarProductResponse;

import java.util.List;

public interface ICarProductService {

    GetCarProductResponse get(Long id);

    List<GetCarProductResponse> list();

    void delete(Long id);

    GetCarProductResponse create(CreateCarProductRequest request);

    GetCarProductResponse update(Long id, UpdateCarProductRequest request);

}
