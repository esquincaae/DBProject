package com.example.demo.controllers.dto.requests;

import com.sun.istack.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class ProductRequest {
    @NotNull
    private String name;
    @NotNull
    private Integer stock;
    @NotNull
    private Double price;
    @NotNull
    private Long categoryId;
    @NotNull
    private String imageUrl;
}
