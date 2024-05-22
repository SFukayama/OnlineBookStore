package com.example.OnlineBookStore.application.dto;

import com.example.OnlineBookStore.domain.model.Book;
import lombok.Data;

@Data
public class BookDTO {

    private int id;
    private String title;
    private String author;
    private int price;
    private int stock;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
    }
}
