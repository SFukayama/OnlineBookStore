package com.example.OnlineBookStore.controller.cart;

import com.example.OnlineBookStore.application.service.CartApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartIndexController {

    private final CartApplicationService cartApplicationService;

    @GetMapping
    public String showCartByCustomerId(Model model) {
        int customerId = 1; // TODO カスタマーIDの管理・受け渡しについて実装
        model.addAttribute("bookListInCart", cartApplicationService.showCartByCustomerId(customerId));
        return "cart/cart";
    }
}
