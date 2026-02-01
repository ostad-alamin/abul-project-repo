package com.abu.abulproject.controller;

import com.abu.abulproject.dto.LoginDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("dto", new LoginDto());
        return "login";
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) {
//        System.err.println(dto.getEmail());
//        System.err.println(dto.getPassword());
//        System.err.println(dto.isRememberMe());
//        model.addAttribute("dto", new LoginDto());
        return ResponseEntity.ok(dto);
    }

}
