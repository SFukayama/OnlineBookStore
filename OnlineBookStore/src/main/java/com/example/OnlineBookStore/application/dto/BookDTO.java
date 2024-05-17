package com.example.OnlineBookStore.application.dto;

import lombok.Data;

@Data
public class BookDTO {

    private int id;
    private String title;
    private String author;
    private int price;
    private int stock;

}
