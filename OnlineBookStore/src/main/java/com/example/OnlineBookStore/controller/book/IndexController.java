package com.example.OnlineBookStore.controller.book;

import com.example.OnlineBookStore.application.service.BookApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("book/index")
@RequiredArgsConstructor
public class IndexController {

    private final BookApplicationService bookApplicationService;

    @GetMapping
    public String bookList(Model model) {
        model.addAttribute("bookList", bookApplicationService.findAll());
        return "book/index";
    }

    @GetMapping("/search")
    public String searchBookListByTitle(@RequestParam("title") String title, Model model){
        model.addAttribute("bookListByTitle", bookApplicationService.findBooksByTitle(title));
        return "book/search";
    }
}