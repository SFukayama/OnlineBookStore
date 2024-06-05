package com.example.OnlineBookStore.application.dto;

import com.example.OnlineBookStore.domain.oath.User;
import lombok.Data;

@Data
public class UserDTO {

    private String username;
    private String password;

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
