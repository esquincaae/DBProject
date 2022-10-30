package com.example.demo.controllers.dto.requests;

public class UpdateUserRequest {
    private String email;
    private String password;


    public UpdateUserRequest() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
