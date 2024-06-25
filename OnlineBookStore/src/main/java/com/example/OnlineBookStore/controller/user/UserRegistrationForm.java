package com.example.OnlineBookStore.controller.user;

import com.example.OnlineBookStore.domain.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegistrationForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private User.Authority authority;
}
