package com.dev.cinema.model.dto.request;

import com.dev.cinema.validation.EmailValidation;

import javax.validation.constraints.NotNull;

public class UserRequestDto {
    @EmailValidation
    private String email;
    @NotNull
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
