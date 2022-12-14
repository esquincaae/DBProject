package com.example.demo.controllers.dto.responses;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private Long categoryId;

}
