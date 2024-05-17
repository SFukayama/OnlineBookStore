package com.example.OnlineBookStore.presentation.controller;

import com.example.OnlineBookStore.application.service.BookApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
@RequiredArgsConstructor
public class IndexController {

    private final BookApplicationService bookApplicationService;

    @GetMapping
    public String bookList(Model model) {
        model.addAttribute("bookList", bookApplicationService.findAll());
        return "index";
    }
}