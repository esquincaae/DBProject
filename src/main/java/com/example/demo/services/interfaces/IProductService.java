package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.CreateProductRequest;
import com.example.demo.controllers.dto.requests.UpdateProductRequest;
import com.example.demo.controllers.dto.responses.GetProductResponse;
import java.util.List;

public interface IProductService {

    GetProductResponse get(Long id);

    List<GetProductResponse> list();

    void delete(Long id);

    GetProductResponse create(CreateProductRequest request);

    GetProductResponse update(Long id, UpdateProductRequest request);
}
