package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.CreateCarProductRequest;
import com.example.demo.controllers.dto.requests.UpdateCarProductRequest;
import com.example.demo.controllers.dto.responses.GetCarProductResponse;
import com.example.demo.controllers.dto.responses.GetUserResponse;
import com.example.demo.services.CarProductService;
import com.example.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car_product")
public class CarProductController {

    @Autowired
    private CarProductService service;

    @GetMapping
    public List<GetCarProductResponse> list(){return service.list();}

    @GetMapping("{id}")
    public GetCarProductResponse get(@PathVariable Long id){return service.get(id);}

    @PostMapping
    public GetCarProductResponse create(@RequestBody CreateCarProductRequest request){return service.create(request);}

    @PutMapping("{id}")
    public GetCarProductResponse update(@PathVariable Long id, @RequestBody UpdateCarProductRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
