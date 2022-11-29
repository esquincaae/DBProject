package com.example.demo.controllers.dto.responses;

import lombok.*;

@Getter @Setter
public class GetProductResponse {
    private Long id;
    private String name;
    private Integer cantprod;
    private Double price;
    private Long categoryId;
}
