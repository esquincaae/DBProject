package com.example.demo.entities;

import com.example.demo.entities.pivots.CarProduct;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Integer cant;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    //@OneToMany(mappedBy = "")
    //private List<CarProduct> carProduct;

}
