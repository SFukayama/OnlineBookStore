package com.example.OnlineBookStore.presentation.controller;

import com.example.OnlineBookStore.application.service.BookApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book")
@RequiredArgsConstructor
public class IndexController {

    private final BookApplicationService bookApplicationService;

    @GetMapping("/index")
    public String bookList(Model model) {
        model.addAttribute("bookList", bookApplicationService.findAll());
        return "index";
    }

    @GetMapping("/{bookId}")
    public String bookDetail(@PathVariable Integer bookId, Model model) {
        model.addAttribute("bookDetail", bookApplicationService.findBookDetailById(bookId));
        return "detail";
    }

}