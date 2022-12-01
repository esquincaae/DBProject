package com.example.demo.services;


import com.example.demo.controllers.dto.requests.CategoryRequest;
import com.example.demo.controllers.dto.responses.CategoryResponse;
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
    public CategoryResponse get(Long id){ return from(id); }

    @Override
    public List<CategoryResponse> list(){
        List<CategoryResponse> responses = new ArrayList<>();
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){repository.deleteById(id);}

    @Override
    public CategoryResponse create(CategoryRequest request){
        Category category = from(request);
        return from(repository.save(category));
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request){
        Category category = repository.findById(id).orElseThrow(() -> new RuntimeException("La categoria no existe"));
        category = update(category, request);
        return from(category);
    }

    private Category update(Category category, CategoryRequest request){
        category.setName(request.getName());
        //category.setProduct(request.getProduct());
        return repository.save(category);
    }

    private Category from(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        //category.setPassword(request.getPassword());
        return category;
    }

    private CategoryResponse from(Category category){
        CategoryResponse response =  new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    private CategoryResponse from(Long idCategory){
        return repository
                .findById(idCategory)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("La categoria no existe"));
    }
}
