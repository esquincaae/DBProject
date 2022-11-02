package com.example.demo.controllers.dto.requests;

import com.example.demo.entities.Rol;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class CreateUserRequest {
    private String email;
    private String password;
    private Rol rol;

}
