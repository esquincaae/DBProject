package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.ProductRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;

public interface IProductService {

    BaseResponse get(Long id);

    BaseResponse list(String keyword);

    BaseResponse delete(Long id);

    BaseResponse create(ProductRequest request);

    BaseResponse update(Long id, ProductRequest request);
}
