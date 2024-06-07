package com.example.OnlineBookStore.controller.user;

import com.example.OnlineBookStore.application.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/userRegistrationForm")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserApplicationService userApplicationService;

    @GetMapping
    public String showUserRegistrationForm(@ModelAttribute UserRegistrationForm userRegistrationForm) {
        return "user/userRegistrationForm";
    }

    @PostMapping
    public String registerUser(@Validated UserRegistrationForm userRegistrationForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return showUserRegistrationForm(userRegistrationForm);
        }
        userApplicationService.registerUser(userRegistrationForm);
        return "redirect:/user/userRegistrationForm";
    }
}
