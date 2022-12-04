package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="rol")
@Getter @Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
/*
    @OneToOne(mappedBy = "roleUser")
    private User user;

 */
    @OneToMany(mappedBy = "role")
    @JsonManagedReference
    private List<User> users;
}
