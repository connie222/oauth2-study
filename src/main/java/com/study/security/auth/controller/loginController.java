package com.study.security.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class loginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("??? login ");
        return "pages/login";
    }
}
