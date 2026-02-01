package com.abu.abulproject.controller;

import com.abu.abulproject.model.User;
import com.abu.abulproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {
    private final UserService userService;

    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboardPage(Model model) {
        List<User> userList = userService.getAll();

        model.addAttribute("userList", userList);
        return "dashboard";
    }

}
