package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.CreateCarRequest;
import com.example.demo.controllers.dto.requests.UpdateCarRequest;
import com.example.demo.controllers.dto.responses.GetCarResponse;
import com.example.demo.services.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarController implements ICarService{

    @Autowired
    @Qualifier("carrito")
    private ICarService service;

    @GetMapping
    public List<GetCarResponse> list(){return service.list();}

    @GetMapping("{id}")
    public GetCarResponse get(@PathVariable Long id){return service.get(id);}

    @PostMapping
    public GetCarResponse create(@RequestBody CreateCarRequest request){return service.create(request);}

    @PutMapping("{id}")
    public GetCarResponse update(@PathVariable Long id, @RequestBody UpdateCarRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
