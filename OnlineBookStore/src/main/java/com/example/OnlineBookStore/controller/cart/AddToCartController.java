package com.example.OnlineBookStore.controller.cart;

import com.example.OnlineBookStore.application.service.CartApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AddToCartController {

    private final CartApplicationService cartApplicationService;

    @PostMapping("/addToCart/{bookId}")
    public String addToCart(@PathVariable int bookId) {
        int customerId = 1;// TODO カスタマーIDの管理・受け渡しについて実装
        cartApplicationService.addToCart(customerId, bookId);
        return "redirect:/book/index";
    }
}
