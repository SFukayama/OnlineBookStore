package com.example.OnlineBookStore.controller.management;

import com.example.OnlineBookStore.application.service.BookApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("management")
@RequiredArgsConstructor
public class BookManagementController {

    private final BookApplicationService bookApplicationService;

    @GetMapping("/{bookId}")
    public String bookManagement(@PathVariable Integer bookId, Model model) {
        model.addAttribute("bookDetail", bookApplicationService.findBookDetailById(bookId));
        return "management/book";
    }
}
