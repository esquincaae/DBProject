package com.example.demo.controllers.dto.responses;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class CreateUserResponse {
    private String email;
    private Long id;
    private String password;
    private Long tipo;


}
