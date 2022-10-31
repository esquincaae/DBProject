package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.CreateCategoryRequest;
import com.example.demo.controllers.dto.requests.UpdateCategoryRequest;
import com.example.demo.controllers.dto.responses.GetCategoryResponse;
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
    public List<GetCategoryResponse> list(){return service.list();}

    @GetMapping("{id}")
    public GetCategoryResponse get(@PathVariable Long id){return service.get(id);}

    @PostMapping
    public GetCategoryResponse create(@RequestBody CreateCategoryRequest request){return service.create(request);}

    @PutMapping("{id}")
    public GetCategoryResponse update(@PathVariable Long id, @RequestBody UpdateCategoryRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
