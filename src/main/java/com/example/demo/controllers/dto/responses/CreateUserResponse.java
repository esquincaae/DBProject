package com.example.demo.controllers.dto.responses;

public class CreateUserResponse {
    private String email;
    private Long id;
    private String password;

    public CreateUserResponse() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
