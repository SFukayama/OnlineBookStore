package com.example.OnlineBookStore.domain.model;

import lombok.Data;

@Data
public class Cart {

    private int cartId;
    private String username;
    private int bookId;
    private int quantity;

    private int id;
    private String title;
    private String author;
    private int price;
    private int stock;
}
