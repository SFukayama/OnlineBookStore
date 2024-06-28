package com.example.OnlineBookStore.controller.cart;

import com.example.OnlineBookStore.application.service.CartApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AddToCartController {

    private final CartApplicationService cartApplicationService;

    @PostMapping("/addToCart/{bookId}")
    public String addToCart(@PathVariable int bookId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        cartApplicationService.addToCart(username, bookId);
        return "redirect:/book/index";
    }
    // TODO 在庫が0のときカートに追加できないようにする
}
