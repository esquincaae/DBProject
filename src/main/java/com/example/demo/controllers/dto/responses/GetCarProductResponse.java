package com.example.demo.controllers.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetCarProductResponse {
    private Long id;
    private Long productId;
    private Integer cantProd;
    private Double totalPrice;
    private Long carId;
    private Long userId;
}
