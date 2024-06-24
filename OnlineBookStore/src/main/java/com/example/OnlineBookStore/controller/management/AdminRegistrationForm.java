package com.example.OnlineBookStore.controller.management;

import com.example.OnlineBookStore.domain.model.User;
import lombok.Data;

@Data
public class AdminRegistrationForm {

    private String username;
    private String password;
    private User.Authority authority;
}
