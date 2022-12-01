package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.ProductRequest;
import com.example.demo.controllers.dto.responses.ProductResponse;
import com.example.demo.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    @Qualifier("product")
    private IProductService service;

    @GetMapping
    public List<ProductResponse> list(){return service.list();}

    @GetMapping("{id}")
    public ProductResponse get(@PathVariable Long id){return service.get(id);}

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request){return service.create(request);}

    @PutMapping("{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
