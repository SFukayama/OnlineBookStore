package com.example.OnlineBookStore.domain.model;

import lombok.Data;

@Data
public class Cart {

    private int customerId;
    private int bookId;
    private int quantity;

    private int id;
    private String title;
    private String author;
    private int price;
    private int stock;
}
