package com.example.OnlineBookStore.controller.cart;

import com.example.OnlineBookStore.application.service.CartApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")

public class CartItemController {

    private final CartApplicationService cartApplicationService;

    @PostMapping("/delete")
    public String deleteItemInCart(@RequestParam("bookId") Integer bookId) {
        int customerId = 1; // TODO カスタマーID
        cartApplicationService.deleteItemInCart(customerId, bookId);
        return "redirect:/cart";
    }
}
