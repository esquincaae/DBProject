package com.example.demo.controllers.dto.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CreateCarProductResponse {
    private Long id;
    private Long productId;
    private Integer cantProd;
    private Double totalPrice;
    private Long carId;
    private Long UserId;
}
