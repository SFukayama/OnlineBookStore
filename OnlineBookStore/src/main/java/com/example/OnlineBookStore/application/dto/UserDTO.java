package com.example.OnlineBookStore.application.dto;

import com.example.OnlineBookStore.domain.model.User;
import lombok.Data;

@Data
public class UserDTO {

    private int userId;
    private String username;
    private String password;
    private User.Authority authority;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authority = user.getAuthority();
    }
}
