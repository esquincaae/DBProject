package com.example.demo.controllers.dto.responses;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class CreateProductResponse {
    private Long id;
    private String name;
    private Double price;
    private Integer cantprod;
    private Long categoryId;

}
