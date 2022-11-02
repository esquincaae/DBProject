package com.example.demo.controllers.dto.responses;
import com.example.demo.entities.Rol;
import lombok.*;

@Getter @Setter
public class GetUserResponse {
    private String email;
    private Long id;
    private String password;
    private Rol role;
}
