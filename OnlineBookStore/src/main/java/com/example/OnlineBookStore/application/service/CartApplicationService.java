package com.example.OnlineBookStore.application.service;

import com.example.OnlineBookStore.application.dto.CartDTO;
import com.example.OnlineBookStore.domain.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartApplicationService {

    private final CartService cartService;

    public void addToCart(String username, int bookId) {
        cartService.addToCart(username, bookId);
    }

    public List<CartDTO> showCartByUsername(String username) {
        return cartService.findCartByUsername(username).stream()
                .map(CartDTO::new)
                .collect(Collectors.toList());
    }

    public void deleteItemInCart(Integer cartId) {
        cartService.deleteItemInCart(cartId);
    }

    public int calculateTotalPriceInCart(String username) {
        return cartService.calculateTotalPriceInCart(username);
    }

    @Transactional
    public void paymentCartByUsername(String username) {
        cartService.saveOrderHistory(username);
        cartService.paymentCartByUsername(username);
    }
}
