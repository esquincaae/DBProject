package com.example.demo.controllers.dto.responses;

import com.example.demo.entities.Rol;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class UserResponse {
    private String email;
    private Long id;
    private Long rolId;


}
