package com.advancedproject.controller;

import com.advancedproject.model.User;
import com.advancedproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Registration Form Page
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    // Handle Registration Form Submission
    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam String email,
                                @RequestParam String phone,
                                @RequestParam String role,
                                Model model) {

        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        newUser.setRole(role);

        userRepository.save(newUser);
        model.addAttribute("message", "Registration successful! Please login.");
        return "login";
    }
}
