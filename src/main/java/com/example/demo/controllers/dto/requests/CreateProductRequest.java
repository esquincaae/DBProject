package com.example.demo.controllers.dto.requests;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor
public class CreateProductRequest {
    @NotNull
    private String name;
    @NotNull
    private Integer cantprod;
    @NotNull
    private Double price;
    @NotNull
    private Long categoryId;
}
