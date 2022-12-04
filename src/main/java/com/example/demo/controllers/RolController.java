package com.example.demo.controllers;

import com.example.demo.controllers.dto.requests.RolRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.services.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RolController {

    @Autowired
    @Qualifier("role")
    private IRolService service;

    @GetMapping
    public ResponseEntity<BaseResponse> list() {
        BaseResponse baseResponse = service.list();

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id) {

        BaseResponse baseResponse = service.get(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody RolRequest request) {
        BaseResponse baseResponse = service.create(request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody RolRequest request) {
        BaseResponse baseResponse = service.update(id, request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {

        BaseResponse baseResponse = service.delete(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

}
