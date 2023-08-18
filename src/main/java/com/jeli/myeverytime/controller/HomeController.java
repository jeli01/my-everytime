package com.jeli.myeverytime.controller;

import com.jeli.myeverytime.domain.Member;
import com.jeli.myeverytime.dto.LoginForm;
import com.jeli.myeverytime.dto.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import static com.jeli.myeverytime.login.SessionConst.LOGIN_MEMBER;

@Controller
public class HomeController {
    @GetMapping
    public String home(
            @SessionAttribute(name = LOGIN_MEMBER, required = false) Member loginMember, Model model
            ) {

        if (loginMember == null) {
            model.addAttribute("loginForm", new LoginForm());
            return "home/home";
        }

        model.addAttribute("member", loginMember);
        return "home/loginHome";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "home/signUp";
    }

    @GetMapping("/authentication-error")
    public String loginError(Model model) {
        return "home/authentication-error";
    }
}
