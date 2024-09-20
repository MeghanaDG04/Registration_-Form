package com.prog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    
    @Autowired
    private UserRepository repo;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @PostMapping("/register")
    public String register(@ModelAttribute("userDtls") UserDtls user, HttpSession session) {
        System.out.println(user);
        repo.save(user);
        session.setAttribute("message", "User registered successfully.");
        return "redirect:/";
    }
}
