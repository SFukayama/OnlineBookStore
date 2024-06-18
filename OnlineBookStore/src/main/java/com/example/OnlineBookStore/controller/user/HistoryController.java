package com.example.OnlineBookStore.controller.user;

import com.example.OnlineBookStore.application.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/history")
public class HistoryController {

    private final UserApplicationService userApplicationService;

    @GetMapping
    public String showHistoryByUsername(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("history", userApplicationService.showHistoryByUsername(username));
        return "/user/history";
    }
}
