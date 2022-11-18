package com.example.demo.controllers.dto.requests;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class UpdateUserRequest {
    private String email;
    private String password;
    private Long role_id;
}
