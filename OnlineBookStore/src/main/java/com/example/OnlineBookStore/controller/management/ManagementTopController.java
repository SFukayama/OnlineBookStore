package com.example.OnlineBookStore.controller.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("management")
public class ManagementTopController {
    @GetMapping("/top")
    public String managementTop(){
        return "management/top";
    }
}
