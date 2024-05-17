package com.example.OnlineBookStore.domain.model;

import lombok.Data;

@Data
public class Book {

    private int id;
    private String title;
    private String author;
    private int price;
    private int stock;

}
