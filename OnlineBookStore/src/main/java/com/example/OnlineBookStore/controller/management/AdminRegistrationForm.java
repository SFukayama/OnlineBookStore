package com.example.OnlineBookStore.controller.management;

import com.example.OnlineBookStore.domain.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminRegistrationForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private User.Authority authority;
}
