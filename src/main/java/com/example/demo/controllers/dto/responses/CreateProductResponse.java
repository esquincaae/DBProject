package com.example.demo.controllers.dto.responses;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class CreateProductResponse {
    private String name;
    private Double price;
    private Long id;
}
