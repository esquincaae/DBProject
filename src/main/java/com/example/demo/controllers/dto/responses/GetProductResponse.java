package com.example.demo.controllers.dto.responses;

import lombok.*;

@Getter @Setter
public class GetProductResponse {
    private String name;
    private Double price;
    private Long id;
}
