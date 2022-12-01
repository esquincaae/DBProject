package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

import com.example.demo.controllers.dto.responses.UserResponse;
import com.example.demo.entities.Rol;
import com.example.demo.entities.User;
import com.example.demo.repositories.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.controllers.dto.requests.UserRequest;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.services.interfaces.IUserService;

@Service("company")
public class UserServiceImpl implements IUserService{
    
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public UserResponse get(Long id){ return from(id); }

    @Override
    public List<UserResponse> list(){
        List<UserResponse> responses = new ArrayList<>();
        return userRepository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);}
    
    @Override
    public UserResponse create(UserRequest request){
        //User user = from(request);
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        Optional<Rol> rol = rolRepository.findById(request.getRolId());
        user.setRole(rol.get());

        return from(userRepository.save(user));
    }

    @Override
    public void update(Long userId, UserRequest userRequest){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("El usuario no existe"));
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
    }

    private User from(UserRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    private UserResponse from(User user){
        UserResponse response =  new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        //response.setPassword(user.getPassword());
        response.setRolId(user.getRole().getId());
        return response;
    }

    private UserResponse from(Long idUser){

        return userRepository
                .findById(idUser)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));
    }
}
