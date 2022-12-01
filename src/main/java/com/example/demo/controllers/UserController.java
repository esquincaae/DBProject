package com.example.demo.controllers;

import com.amazonaws.Response;
import com.example.demo.controllers.dto.requests.UserRequest;
import com.example.demo.controllers.dto.responses.UserResponse;
import com.example.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    @Qualifier("company")
    private IUserService service;

    @GetMapping
    public List<UserResponse> list(){return service.list();}

    @GetMapping("{id}")
    public UserResponse get(@PathVariable Long id){return service.get(id);}

    @PostMapping
    public ResponseEntity create(@RequestBody UserRequest request){
        return ResponseEntity.ok(service.create(request));
    }
    
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody UserRequest request) {
        service.update(id, request);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
