package com.example.OnlineBookStore.controller.user;

import com.example.OnlineBookStore.application.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserListController {

    private final UserApplicationService userApplicationService;

    @GetMapping("/userList")
    public String userList(Model model) {
        model.addAttribute("userList", userApplicationService.findAllUserList());
        return "user/userList";
    }
}
