package com.example.OnlineBookStore.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private int userId;
    private String username;
    private String password;
    private Authority authority;

    public enum Authority {
        ADMIN,
        USER,
    }
}