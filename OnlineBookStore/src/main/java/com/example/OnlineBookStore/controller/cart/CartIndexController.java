package com.example.OnlineBookStore.controller.cart;

import com.example.OnlineBookStore.application.service.CartApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public String showCartByUsername(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("bookListInCart", cartApplicationService.showCartByUsername(username));
        model.addAttribute("totalPrice", cartApplicationService.calculateTotalPriceInCart(username));
        return "cart/cart";
    }
}
