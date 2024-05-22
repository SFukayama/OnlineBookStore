package com.example.OnlineBookStore.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {
    @GetMapping
    public String top() {
        return "top";
    }

}
