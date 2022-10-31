package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.CreateRolRequest;
import com.example.demo.controllers.dto.requests.UpdateRolRequest;
import com.example.demo.controllers.dto.responses.GetRolResponse;
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
    public List<GetRolResponse> list(){return service.list();}

    @GetMapping("{id}")
    public GetRolResponse get(@PathVariable Long id){return service.get(id);}

    @PostMapping
    public GetRolResponse create(@RequestBody CreateRolRequest request){return service.create(request);}

    @PutMapping("{id}")
    public GetRolResponse update(@PathVariable Long id, @RequestBody UpdateRolRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
