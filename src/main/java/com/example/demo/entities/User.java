package com.example.demo.entities;

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
    private Long tipo;

/*
    @OneToOne
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Rol roleUser;*/
    @ManyToOne
    @JoinColumn (name = "product_rol")
    public Rol rol;
}