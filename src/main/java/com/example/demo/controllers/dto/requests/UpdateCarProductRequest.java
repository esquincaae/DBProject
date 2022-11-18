package com.example.demo.controllers.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UpdateCarProductRequest {
    private Long id;
    private Long productId;
    private Integer cantProd;
    private Long carId;
}
