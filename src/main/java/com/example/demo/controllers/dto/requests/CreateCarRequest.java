package com.example.demo.controllers.dto.requests;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class CreateCarRequest {
    private Double precioTotal;
    private Long userId;
    private Long productId;
}
