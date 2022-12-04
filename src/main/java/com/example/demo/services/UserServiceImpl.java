package com.example.demo.services;

import com.example.demo.controllers.dto.requests.UserRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.controllers.dto.responses.UserResponse;
import com.example.demo.entities.Rol;
import com.example.demo.entities.User;
import com.example.demo.repositories.IRolRepository;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("company")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public BaseResponse get(Long id) {
        User user = findAndEnsureExist(id);

        return BaseResponse.builder()
                .data(user)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse list() {
        List<UserResponse> users = userRepository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());

        return BaseResponse.builder()
                .data(users)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse delete(Long id) {
        userRepository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public BaseResponse create(UserRequest request) {
        //User user = from(request);
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(encodePassword(request.getPassword()));
        Optional<Rol> rol = rolRepository.findById(request.getRolId());
        user.setRole(rol.get());

        User userSaved = userRepository.save(user);

        return BaseResponse.builder()
                .data(userSaved)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse update(Long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("El usuario no existe"));
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        User userUpdated = userRepository.save(user);

        return BaseResponse.builder()
                .data(userUpdated)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private User from(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    private UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        //response.setPassword(user.getPassword());
        response.setRolId(user.getRole().getId());
        return response;
    }

    private User findAndEnsureExist(Long idUser) {

        return userRepository
                .findById(idUser)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));
    }

    private static String encodePassword(String request) {
        return new BCryptPasswordEncoder().encode(request);
    }
}
