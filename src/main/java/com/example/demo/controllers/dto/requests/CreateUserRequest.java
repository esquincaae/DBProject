package com.example.demo.controllers.dto.requests;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class CreateUserRequest {
    private String email;
    private String password;
    private Long tipo;

}
