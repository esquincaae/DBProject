package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

import com.example.demo.entities.Rol;
import com.example.demo.entities.User;
import com.example.demo.repositories.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.controllers.dto.requests.CreateUserRequest;
import com.example.demo.controllers.dto.requests.UpdateUserRequest;
import com.example.demo.controllers.dto.responses.GetUserResponse;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.services.interfaces.IUserService;

@Service("company")
public class UserServiceImpl implements IUserService{
    
    @Autowired
    private IUserRepository repository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public GetUserResponse get(Long id){ return from(id); }

    @Override
    public List<GetUserResponse> list(){
        List<GetUserResponse> responses = new ArrayList<>();
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){repository.deleteById(id);}
    
    @Override
    public GetUserResponse create(CreateUserRequest request){
        //User user = from(request);
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        Optional<Rol> rol = rolRepository.findById(request.getRolId());
        user.setRole(rol.get());

        return from(repository.save(user));
    }

    @Override
    public GetUserResponse update(Long id, UpdateUserRequest request){
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("El usuario no existe"));
        user = update(user, request);
        return from(user);
    }

    private User update(User user, UpdateUserRequest request){
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return repository.save(user);
    }

    private User from(CreateUserRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    private GetUserResponse from(User user){
        GetUserResponse response =  new GetUserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        return response;
    }

    private GetUserResponse from(Long idUser){
        return repository
                .findById(idUser)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));
    }
}
