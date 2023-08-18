package com.jeli.myeverytime.service;

import com.jeli.myeverytime.domain.Member;
import com.jeli.myeverytime.dto.LoginForm;
import com.jeli.myeverytime.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(Member member) {
        memberRepository.save(member);
    }

    public void login(LoginForm loginForm) {
        String loginId = loginForm.getLoginId();
        String password = loginForm.getPassword();
    }
}
