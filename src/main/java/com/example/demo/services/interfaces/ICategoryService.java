package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.CreateCategoryRequest;
import com.example.demo.controllers.dto.requests.UpdateCategoryRequest;
import com.example.demo.controllers.dto.responses.GetCategoryResponse;

import java.util.List;

public interface ICategoryService {
    GetCategoryResponse get(Long id);

    List<GetCategoryResponse> list();

    void delete(Long id);

    GetCategoryResponse create(CreateCategoryRequest request);

    GetCategoryResponse update(Long id, UpdateCategoryRequest request);
}
