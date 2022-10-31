package com.example.demo.services;


import com.example.demo.controllers.dto.requests.CreateCategoryRequest;
import com.example.demo.controllers.dto.requests.UpdateCategoryRequest;
import com.example.demo.controllers.dto.responses.GetCategoryResponse;
import com.example.demo.entities.Category;
import com.example.demo.repositories.ICategoryRepository;
import com.example.demo.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("categoria")
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public GetCategoryResponse get(Long id){ return from(id); }

    @Override
    public List<GetCategoryResponse> list(){
        List<GetCategoryResponse> responses = new ArrayList<>();
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){repository.deleteById(id);}

    @Override
    public GetCategoryResponse create(CreateCategoryRequest request){
        Category category = from(request);
        return from(repository.save(category));
    }

    @Override
    public GetCategoryResponse update(Long id, UpdateCategoryRequest request){
        Category category = repository.findById(id).orElseThrow(() -> new RuntimeException("La categoria no existe"));
        category = update(category, request);
        return from(category);
    }

    private Category update(Category category, UpdateCategoryRequest request){
        category.setName(request.getName());
        //category.setProduct(request.getProduct());
        return repository.save(category);
    }

    private Category from(CreateCategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        //category.setPassword(request.getPassword());
        return category;
    }

    private GetCategoryResponse from(Category category){
        GetCategoryResponse response =  new GetCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    private GetCategoryResponse from(Long idCategory){
        return repository
                .findById(idCategory)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("La categoria no existe"));
    }
}
