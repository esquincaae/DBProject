package com.example.demo.controllers;

import com.amazonaws.services.servicecatalog.model.UpdateProductRequest;
import com.example.demo.controllers.dto.requests.CreateProductRequest;
import com.example.demo.controllers.dto.responses.GetProductResponse;
import com.example.demo.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("Product")
public class ProductController {

    @Autowired
    @Qualifier("productos")
    private IProductService service;

    @GetMapping
    public List<GetProductResponse> list(){return service.list();}

    @GetMapping("{id}")
    public GetProductResponse get(@PathVariable Long id){return service.get(id);}

    @PostMapping
    public GetProductResponse create(@RequestBody CreateProductRequest request){return service.create(request);}

    @PutMapping("{id}")
    public GetProductResponse update(@PathVariable Long id, @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
