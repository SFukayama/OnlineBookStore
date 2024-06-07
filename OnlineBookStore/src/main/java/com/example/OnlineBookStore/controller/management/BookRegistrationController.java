package com.example.OnlineBookStore.controller.management;

import com.example.OnlineBookStore.application.service.BookApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("management/bookRegistrationForm")
@RequiredArgsConstructor
public class BookRegistrationController {

    private final BookApplicationService bookApplicationService;

    @GetMapping
    public String showBookRegistrationForm(@ModelAttribute BookRegistrationForm bookRegistrationForm) {
        return "management/bookRegistrationForm";
    }

    @PostMapping
    public String registerBook(@Validated BookRegistrationForm bookRegistrationForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return showBookRegistrationForm(bookRegistrationForm);
        }
        bookApplicationService.registerBook(bookRegistrationForm);
        return "redirect:/management/bookRegistrationForm";
    }
}