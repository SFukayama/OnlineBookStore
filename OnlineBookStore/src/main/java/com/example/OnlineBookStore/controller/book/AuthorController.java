package com.example.OnlineBookStore.controller.book;

import com.example.OnlineBookStore.application.service.BookApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book/author")
@RequiredArgsConstructor
public class AuthorController {

    private final BookApplicationService bookApplicationService;

    @GetMapping("/{author}")
    public String bookListByAuthor(@PathVariable String author, Model model) {
        model.addAttribute("bookListByAuthor", bookApplicationService.findBooksByAuthor(author));
        model.addAttribute("author", author);
        return "book/author";
    }
}
