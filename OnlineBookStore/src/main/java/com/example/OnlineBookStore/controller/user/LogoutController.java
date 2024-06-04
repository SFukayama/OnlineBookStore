package com.example.OnlineBookStore.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LogoutController {

    @GetMapping("/logout")
    public String showLogoutForm() {
        return "/user/logout";
    }
}
