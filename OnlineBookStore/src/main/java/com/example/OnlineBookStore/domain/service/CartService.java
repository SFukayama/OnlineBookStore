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

    public void addToCart(int customerId, int bookId) {
        cartRepository.addToCart(customerId, bookId);
    }

    public List<Cart> findCartByCustomerId(Integer customerId) {
        return cartRepository.findCartByCustomerId(customerId);
    }

    public void deleteItemInCart(Integer customerId, Integer bookId) {
        cartRepository.deleteItemInCart(customerId, bookId);
    }
}
