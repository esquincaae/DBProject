package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne()
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car_id;
    @ManyToOne
    @JoinColumn (name = "role_id", referencedColumnName = "id")
    private Rol role;
}