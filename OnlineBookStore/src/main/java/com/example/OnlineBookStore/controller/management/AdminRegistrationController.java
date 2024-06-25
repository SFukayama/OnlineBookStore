package com.example.OnlineBookStore.controller.management;

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
@RequestMapping("management/adminRegistrationForm")
@RequiredArgsConstructor
public class AdminRegistrationController {

    private final UserApplicationService userApplicationService;

    @GetMapping
    public String showAdminRegistrationForm(@ModelAttribute AdminRegistrationForm adminRegistrationForm) {
        return "management/adminRegistrationForm";
    }

    @PostMapping
    public String registerAdmin(@Validated AdminRegistrationForm adminRegistrationForm, BindingResult bindingResult) {
        if (!userApplicationService.isUsernameUnique(adminRegistrationForm.getUsername())) {
            bindingResult.rejectValue("username", "error.userRegistrationForm", "このユーザー名は既に使用されています");
        }
        if (bindingResult.hasErrors()) {
            return showAdminRegistrationForm(adminRegistrationForm);
        }
        userApplicationService.registerAdmin(adminRegistrationForm);
        return "redirect:/management/adminRegistrationForm";
    }
}
