package com.ddadak.springbootblog.common.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() {
        return "user/oauthLogin";
    }

    @GetMapping("/signup")
    public String signup() {
        return "user/signup";
    }
}
