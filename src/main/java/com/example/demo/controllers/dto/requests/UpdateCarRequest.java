package com.example.demo.controllers.dto.requests;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class UpdateCarRequest {
    private Double precioTotal;
    private Long userId;
    private Long productId;
}
