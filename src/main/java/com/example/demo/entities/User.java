package com.example.demo.entities;

import com.example.demo.entities.pivots.Cart;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @ManyToOne
    @JoinColumn (name = "role_id", referencedColumnName = "id")
    private Rol role;
}