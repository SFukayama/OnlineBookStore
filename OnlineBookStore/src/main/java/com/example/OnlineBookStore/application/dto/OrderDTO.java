package com.example.OnlineBookStore.application.dto;

import com.example.OnlineBookStore.domain.model.Order;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {

    private String username;
    private int bookId;
    private LocalDate date;

    private int id;
    private String title;
    private String author;
    private int price;
    private int stock;

    public OrderDTO(Order order) {

        this.username = order.getUsername();
        this.bookId = order.getBookId();
        this.date = order.getDate();
        this.id = order.getId();
        this.title = order.getTitle();
        this.author = order.getAuthor();
        this.price = order.getPrice();
        this.stock = order.getStock();
    }
}
