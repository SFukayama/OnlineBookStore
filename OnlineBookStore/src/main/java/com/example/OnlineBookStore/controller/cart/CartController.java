package com.example.OnlineBookStore.controller.cart;

import com.example.OnlineBookStore.application.service.CartApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartApplicationService cartApplicationService;

    @PostMapping("/addToCart/{bookId}")
    public String addToCart(@PathVariable int bookId) {
        int customerId = 1; // TODO カスタマーIDの管理・受け渡しについて実装
        cartApplicationService.addToCart(customerId, bookId);
        return "redirect:/book/index";
    }

    @GetMapping("/cart")
    public String showCartByCustomerId(Model model) {
        int customerId = 1; // TODO カスタマーIDの管理・受け渡しについて実装
        model.addAttribute("bookListInCart", cartApplicationService.showCartByCustomerId(customerId));
        return "book/cart";
    }
}
