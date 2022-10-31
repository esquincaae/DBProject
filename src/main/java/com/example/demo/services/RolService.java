package com.example.demo.services;

import com.example.demo.controllers.dto.requests.CreateRolRequest;
import com.example.demo.controllers.dto.requests.UpdateRolRequest;
import com.example.demo.controllers.dto.responses.GetRolResponse;
import com.example.demo.entities.Rol;
import com.example.demo.repositories.IRolRepository;
import com.example.demo.services.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("role")
public class RolService implements IRolService {
    @Autowired
    private IRolRepository repository;

    @Override
    public GetRolResponse get(Long id){ return from(id); }

    @Override
    public List<GetRolResponse> list(){
        List<GetRolResponse> responses = new ArrayList<>();
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){repository.deleteById(id);}

    @Override
    public GetRolResponse create(CreateRolRequest request){
        Rol rol = from(request);
        return from(repository.save(rol));
    }

    @Override
    public GetRolResponse update(Long id, UpdateRolRequest request){
        Rol rol = repository.findById(id).orElseThrow(() -> new RuntimeException("El rol no existe"));
        rol = update(rol, request);
        return from(rol);
    }

    private Rol update(Rol rol, UpdateRolRequest request){
        rol.setNombre(request.getName());
        //user.setPassword(request.getPassword());
        return repository.save(rol);
    }

    private Rol from(CreateRolRequest request){
        Rol rol = new Rol();
        rol.setNombre(request.getName());
        //user.setPassword(request.getPassword());
        return rol;
    }

    private GetRolResponse from(Rol rol){
        GetRolResponse response =  new GetRolResponse();
        response.setId(rol.getId());
        response.setName(rol.getNombre());
        return response;
    }

    private GetRolResponse from(Long idRol){
        return repository
                .findById(idRol)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El rol no existe"));
    }
}
