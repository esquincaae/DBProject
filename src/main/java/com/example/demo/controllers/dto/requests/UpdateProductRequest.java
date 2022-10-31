package com.example.demo.controllers.dto.requests;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class UpdateProductRequest {
    private String name;
    private Double price;
}
