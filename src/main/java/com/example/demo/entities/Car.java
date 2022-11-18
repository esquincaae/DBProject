package com.example.demo.entities;

import com.example.demo.entities.pivots.CarProduct;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double precioTotal;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    @OneToMany(mappedBy = "carId")
    private List<CarProduct> carProduct;

}
