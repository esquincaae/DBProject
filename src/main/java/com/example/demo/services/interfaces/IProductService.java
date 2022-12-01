package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.ProductRequest;
import com.example.demo.controllers.dto.responses.ProductResponse;

import java.util.List;

public interface IProductService {

    ProductResponse get(Long id);

    List<ProductResponse> list();

    void delete(Long id);

    ProductResponse create(ProductRequest request);

    ProductResponse update(Long id, ProductRequest request);
}
