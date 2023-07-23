package com.example.springbackoffice.controller;

import com.example.springbackoffice.jwt.JwtUtil;
import com.example.springbackoffice.repository.UserRepository;
import com.example.springbackoffice.service.CommentService;
import com.example.springbackoffice.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UserViewController {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/signup-page")
    public String SignupPage() {
        return "signup";
    }

    @GetMapping("/login-page")
    public String login(){
        return "login";
    }


}

