package com.example.demo.services;

import com.example.demo.controllers.dto.requests.RolRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.controllers.dto.responses.RolResponse;
import com.example.demo.entities.Rol;
import com.example.demo.repositories.IRolRepository;
import com.example.demo.services.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("role")
public class RolService implements IRolService {
    @Autowired
    private IRolRepository repository;

    @Override
    public BaseResponse get(Long id) {
        Rol rol = findAndEnsureExist(id);

        return BaseResponse.builder()
                .data(rol)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse list() {
        List<RolResponse> rols = repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());

        return BaseResponse.builder()
                .data(rols)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse delete(Long id) {
        repository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public BaseResponse create(RolRequest request) {
        Rol rol = repository.save(from(request));

        return BaseResponse.builder()
                .data(rol)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse update(Long id, RolRequest request) {
        Rol rol = repository.findById(id).orElseThrow(() -> new RuntimeException("El rol no existe"));
        rol = update(rol, request);

        return BaseResponse.builder()
                .data(rol)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private Rol update(Rol rol, RolRequest request) {
        rol.setNombre(request.getName());
        //user.setPassword(request.getPassword());
        return repository.save(rol);
    }

    private Rol from(RolRequest request) {
        Rol rol = new Rol();
        rol.setNombre(request.getName());
        //user.setPassword(request.getPassword());
        return rol;
    }

    private RolResponse from(Rol rol) {
        RolResponse response = new RolResponse();
        response.setId(rol.getId());
        response.setName(rol.getNombre());
        return response;
    }

    private Rol findAndEnsureExist(Long idRol) {
        return repository
                .findById(idRol)
                .orElseThrow(() -> new RuntimeException("El rol no existe"));
    }
}
