package com.example.demo.controllers.dto.requests;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class CreateProductRequest {
    private String name;
    private Double price;
}
