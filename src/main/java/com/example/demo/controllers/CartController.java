package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.CartRequest;
import com.example.demo.controllers.dto.responses.CartResponse;
import com.example.demo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("{id}")
    public List<CartResponse> list(@PathVariable Long id) {
        return service.list(id);
    }

    /*@GetMapping("{id}")
    public CartResponse get(@PathVariable Long id) {
        return service.get(id);
    }*/

    @PostMapping
    public CartResponse create(@RequestBody CartRequest request) {
        return service.create(request);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody CartRequest request) {
        service.update(id, request);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
