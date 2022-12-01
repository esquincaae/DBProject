package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.CategoryRequest;
import com.example.demo.controllers.dto.responses.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    CategoryResponse get(Long id);

    List<CategoryResponse> list();

    void delete(Long id);

    CategoryResponse create(CategoryRequest request);

    CategoryResponse update(Long id, CategoryRequest request);
}
