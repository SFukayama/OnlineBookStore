package com.example.OnlineBookStore.application.dto;

import com.example.OnlineBookStore.domain.model.Cart;
import lombok.Data;

@Data
public class CartDTO {

    private int cartId;
    private String username;
    private int bookId;
    private int quantity;

    private int id;
    private String title;
    private String author;
    private int price;
    private int stock;

    public CartDTO(Cart cart) {

        this.cartId = cart.getCartId();
        this.username = cart.getUsername();
        this.bookId = cart.getBookId();
        this.quantity = cart.getQuantity();
        this.id = cart.getId();
        this.title = cart.getTitle();
        this.author = cart.getAuthor();
        this.price = cart.getPrice();
        this.stock = cart.getStock();
    }
}
