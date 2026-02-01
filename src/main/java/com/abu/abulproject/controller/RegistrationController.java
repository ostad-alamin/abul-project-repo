package com.abu.abulproject.controller;

import com.abu.abulproject.dto.LoginDto;
import com.abu.abulproject.dto.RegistrationDto;
import com.abu.abulproject.model.Name;
import com.abu.abulproject.model.User;
import com.abu.abulproject.model.UserType;
import com.abu.abulproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("dto", new RegistrationDto());
        return "registration";
    }
    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDto dto) {
        if (!dto.getEmail().contains("alamin")) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        User user = new User();
        user.setName(new Name(dto.getFirstName(), dto.getLastName()));
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUserType(UserType.USER);
        userService.save(user);

//        LoginDto loginDto = new LoginDto();
//        loginDto.setEmail(dto.getEmail());
//        loginDto.setPassword(dto.getPassword());
//        loginDto.setRegistrationSuccess(true);
//        model.addAttribute("dto", loginDto);
//        return "login";
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
