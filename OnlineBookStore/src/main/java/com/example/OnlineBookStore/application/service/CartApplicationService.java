package com.example.OnlineBookStore.application.service;

import com.example.OnlineBookStore.application.dto.CartDTO;
import com.example.OnlineBookStore.domain.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartApplicationService {

    private final CartService cartService;

    public void addToCart(int customerId, int bookId) {
        cartService.addToCart(customerId, bookId);
    }

    public List<CartDTO> showCartByCustomerId(int customerId) {
        return cartService.findCartByCustomerId(customerId).stream()
                .map(CartDTO::new)
                .collect(Collectors.toList());
    }
}
