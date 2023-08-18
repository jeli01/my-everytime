package com.jeli.myeverytime.interceptor;

import com.jeli.myeverytime.login.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

import static com.jeli.myeverytime.login.SessionConst.LOGIN_MEMBER;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute(LOGIN_MEMBER) == null) {
            response.sendRedirect("/authentication-error");
            return false;
        }

        return true;
    }
}
