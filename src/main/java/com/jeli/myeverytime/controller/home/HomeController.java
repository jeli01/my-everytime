package com.jeli.myeverytime.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String home() {
        return "home/guest-home";
    }

    @GetMapping("/user-test")
    public String home2() {
        return "home/user-home";
    }

    @GetMapping("/login-authentication")
    public String home3() {
        return "myError/authentication-error";
    }

    @GetMapping("/sign-up")
    public String home4() {
        return "home/sign-up";
    }
}
