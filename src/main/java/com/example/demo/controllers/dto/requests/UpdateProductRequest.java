package com.example.demo.controllers.dto.requests;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class UpdateProductRequest {
    private String name;
    private Integer cantprod;
    private Double price;
    private Long categoryId;
}
