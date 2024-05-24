package com.example.OnlineBookStore.controller.book;

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
@RequestMapping("book/registrationForm")
@RequiredArgsConstructor
public class RegistrationController {

    private final BookApplicationService bookApplicationService;

    @GetMapping
    public String bookRegistration(@ModelAttribute RegistrationForm registrationForm) {
        return "book/registrationForm";
    }

    @PostMapping
    public String registerBook(@Validated RegistrationForm registrationForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bookRegistration(registrationForm);
        }
        bookApplicationService.registerBook(registrationForm);
        return "redirect:/book/registrationForm";
    }
}