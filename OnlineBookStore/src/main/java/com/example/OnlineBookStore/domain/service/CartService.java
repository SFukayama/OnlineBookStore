package com.example.OnlineBookStore.domain.service;

import com.example.OnlineBookStore.domain.model.Cart;
import com.example.OnlineBookStore.domain.model.Order;
import com.example.OnlineBookStore.domain.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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

    public void paymentCartByUsername(String username) {
        cartRepository.deleteCartByUsername(username);
        //  TODO 在庫を減らす処理
        //  cartRepository.reduceStock(username);
        //　TODO　支払いのシステムに決済情報を受け渡す処理(要不要から考える)
    }

    public void saveOrderHistory(String username) {
        // 東京の現在時刻を取得
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZonedDateTime tokyoNow = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        // DBからカート情報を取得
        List<Cart> carts = cartRepository.findCartByUsername(username);
        // データの詰めなおしと日時を追加
        List<Order> orderList = carts.stream()
                .map(cart -> {
                    Order order = new Order();
                    order.setUsername(username);
                    order.setBookId(cart.getBookId());
                    order.setDate(LocalDate.parse(tokyoNow.format(dateTimeFormatter)));
                    return order;
                })
                .collect(Collectors.toList());
        cartRepository.saveOrderHistory(orderList);
    }
}
