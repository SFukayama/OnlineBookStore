package com.example.OnlineBookStore.controller.management;

import com.example.OnlineBookStore.application.service.BookApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("management/{bookId}")
@RequiredArgsConstructor
public class BookManagementController {

    private final BookApplicationService bookApplicationService;

    @GetMapping
    public String bookManagement(@PathVariable Integer bookId, Model model, @ModelAttribute BookRegistrationForm bookRegistrationForm) {
        model.addAttribute("bookDetail", bookApplicationService.findBookDetailById(bookId));
        return "management/book";
    }

    @PostMapping
    public String updateBook(@Validated BookRegistrationForm bookRegistrationForm, BindingResult bindingResult) {
        bookApplicationService.updateBookById(bookRegistrationForm);
        return "redirect:/management/top";
    }

}
