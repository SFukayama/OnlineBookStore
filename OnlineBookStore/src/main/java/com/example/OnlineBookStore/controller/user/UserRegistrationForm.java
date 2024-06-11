package com.example.OnlineBookStore.controller.user;

import com.example.OnlineBookStore.domain.oath.User;
import lombok.Data;

@Data
public class UserRegistrationForm {

    private String username;
    private String password;
    private User.Authority authority;
}
