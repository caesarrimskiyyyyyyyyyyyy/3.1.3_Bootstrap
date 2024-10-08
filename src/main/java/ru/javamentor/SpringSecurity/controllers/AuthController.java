package ru.javamentor.SpringSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping
    public String login() {
        return "auth/login";
    }
}
