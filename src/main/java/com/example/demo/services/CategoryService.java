package com.example.demo.services;


import com.example.demo.controllers.dto.requests.CategoryRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.controllers.dto.responses.CategoryResponse;
import com.example.demo.entities.Category;
import com.example.demo.repositories.ICategoryRepository;
import com.example.demo.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("categoria")
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public BaseResponse get(Long id) {
        Category category = findAndEnsureExist(id);

        return BaseResponse.builder()
                .data(category)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse list() {
        List<CategoryResponse> categories = repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());

        return BaseResponse.builder()
                .data(categories)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse delete(Long id) {
        repository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public BaseResponse create(CategoryRequest request) {
        Category category = repository.save(from(request));

        return BaseResponse.builder()
                .data(category)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse update(Long id, CategoryRequest request) {
        Category category = repository.findById(id).orElseThrow(() -> new RuntimeException("La categoria no existe"));
        category = update(category, request);

        return BaseResponse.builder()
                .data(category)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private Category update(Category category, CategoryRequest request) {
        category.setName(request.getName());
        //category.setProduct(request.getProduct());
        return repository.save(category);
    }

    private Category from(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        //category.setPassword(request.getPassword());
        return category;
    }

    private CategoryResponse from(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    private Category findAndEnsureExist(Long idCategory) {
        return repository
                .findById(idCategory)
                .orElseThrow(() -> new RuntimeException("La categoria no existe"));
    }
}
