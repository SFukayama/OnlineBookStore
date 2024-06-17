package com.example.OnlineBookStore.domain.service;

import com.example.OnlineBookStore.domain.model.Cart;
import com.example.OnlineBookStore.domain.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public void addToCart(String username, int bookId) {
        cartRepository.addToCart(username, bookId);
    }

    public List<Cart> findCartByUsername(String username) {
        return cartRepository.findCartByUsername(username);
    }

    public void deleteItemInCart(Integer cartId) {
        cartRepository.deleteItemInCart(cartId);
    }

    public int calculateTotalPriceInCart(String username) {
        List<Cart> booksInCart = cartRepository.findCartByUsername(username);
        int totalPrice = booksInCart.stream()
                .mapToInt(Cart::getPrice)
                .sum();
        return totalPrice;
    }
}
