package com.example.demo.controllers.dto.responses;

import com.example.demo.entities.Rol;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class CreateUserResponse {
    private String email;
    private Long id;
    private String password;
<<<<<<< HEAD
    private Long rolId;
=======
    private Long rol;
>>>>>>> 2cb5f4c84dceea73203c934ab3b8a15261354c3e


}
