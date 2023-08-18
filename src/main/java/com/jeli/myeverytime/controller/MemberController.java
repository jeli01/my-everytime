package com.jeli.myeverytime.controller;

import com.jeli.myeverytime.domain.Member;
import com.jeli.myeverytime.dto.LoginForm;
import com.jeli.myeverytime.dto.SignUpForm;
import com.jeli.myeverytime.login.SessionConst;
import com.jeli.myeverytime.repository.MemberRepository;
import com.jeli.myeverytime.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping
    public String signUp(@ModelAttribute SignUpForm form) {
        Member member = new Member();
        member.setLoginId(form.getLoginId());
        member.setPassword(form.getPassword());
        member.setNickname(form.getNickname());
        member.setCreateDate(LocalDateTime.now());
        member.setUpdateDate(LocalDateTime.now());

        memberService.signUp(member);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form, HttpServletRequest request) {
        Member loginMember = memberRepository.findByLoginIdAndPassword(form.getLoginId(), form.getPassword());

        if (loginMember != null) {
            HttpSession session = request.getSession();
            session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        }

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();

        return "redirect:/";
    }
}
