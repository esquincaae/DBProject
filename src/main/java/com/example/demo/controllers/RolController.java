package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.RolRequest;
import com.example.demo.controllers.dto.responses.RolResponse;
import com.example.demo.services.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RolController {

    @Autowired
    @Qualifier("role")
    private IRolService service;

    @GetMapping
    public List<RolResponse> list(){return service.list();}

    @GetMapping("{id}")
    public RolResponse get(@PathVariable Long id){return service.get(id);}

    @PostMapping
    public RolResponse create(@RequestBody RolRequest request){return service.create(request);}

    @PutMapping("{id}")
    public RolResponse update(@PathVariable Long id, @RequestBody RolRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
