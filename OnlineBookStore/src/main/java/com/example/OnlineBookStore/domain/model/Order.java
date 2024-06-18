package com.example.OnlineBookStore.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Order {

    private String username;
    private int bookId;
    private LocalDate date;
}
