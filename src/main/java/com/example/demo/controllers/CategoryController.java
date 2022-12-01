package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.CategoryRequest;
import com.example.demo.controllers.dto.responses.CategoryResponse;
import com.example.demo.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    @Qualifier("categoria")
    private ICategoryService service;

    @GetMapping
    public List<CategoryResponse> list(){return service.list();}

    @GetMapping("{id}")
    public CategoryResponse get(@PathVariable Long id){return service.get(id);}

    @PostMapping
    public CategoryResponse create(@RequestBody CategoryRequest request){return service.create(request);}

    @PutMapping("{id}")
    public CategoryResponse update(@PathVariable Long id, @RequestBody CategoryRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
