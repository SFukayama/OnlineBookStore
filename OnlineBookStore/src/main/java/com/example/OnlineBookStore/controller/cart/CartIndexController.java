package com.example.OnlineBookStore.controller.cart;

import com.example.OnlineBookStore.application.service.CartApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CartIndexController {

    private final CartApplicationService cartApplicationService;

    @GetMapping("/cart")
    public String showCartByCustomerId(Model model) {
        int customerId = 1; // TODO カスタマーIDの管理・受け渡しについて実装
        model.addAttribute("bookListInCart", cartApplicationService.showCartByCustomerId(customerId));
        return "book/cart";
    }
}
