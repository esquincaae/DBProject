package com.example.demo.services;

import com.example.demo.controllers.dto.requests.RolRequest;
import com.example.demo.controllers.dto.responses.RolResponse;
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
    public RolResponse get(Long id){ return from(id); }

    @Override
    public List<RolResponse> list(){
        List<RolResponse> responses = new ArrayList<>();
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){repository.deleteById(id);}

    @Override
    public RolResponse create(RolRequest request){
        Rol rol = from(request);
        return from(repository.save(rol));
    }

    @Override
    public RolResponse update(Long id, RolRequest request){
        Rol rol = repository.findById(id).orElseThrow(() -> new RuntimeException("El rol no existe"));
        rol = update(rol, request);
        return from(rol);
    }

    private Rol update(Rol rol, RolRequest request){
        rol.setNombre(request.getName());
        //user.setPassword(request.getPassword());
        return repository.save(rol);
    }

    private Rol from(RolRequest request){
        Rol rol = new Rol();
        rol.setNombre(request.getName());
        //user.setPassword(request.getPassword());
        return rol;
    }

    private RolResponse from(Rol rol){
        RolResponse response =  new RolResponse();
        response.setId(rol.getId());
        response.setName(rol.getNombre());
        return response;
    }

    private RolResponse from(Long idRol){
        return repository
                .findById(idRol)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El rol no existe"));
    }
}
