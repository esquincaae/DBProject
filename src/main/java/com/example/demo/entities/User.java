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

    @OneToMany(mappedBy = "user_id")
    private List<Car> cars;
    @ManyToOne
    @JoinColumn (name = "role_id", referencedColumnName = "id")
    private Rol role;
}