package com.example.OnlineBookStore.controller.management;

import com.example.OnlineBookStore.application.service.BookApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("management")
@RequiredArgsConstructor
public class ManagementTopController {

    private final BookApplicationService bookApplicationService;

    @GetMapping("/top")
    public String managementTop(Model model) {
        model.addAttribute("bookList", bookApplicationService.findAll());
        return "management/top";
    }
}
