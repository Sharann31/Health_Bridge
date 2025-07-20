package com.advancedproject.controller;

import com.advancedproject.model.User;
import com.advancedproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {

        Optional<User> userOptional = userRepository.findByUsername(username);

        if (!userOptional.isPresent() || !userOptional.get().getPassword().equals(password)) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
        
        User user = userOptional.get();
        session.setAttribute("loggedInUsername", username);
        session.setAttribute("loggedInRole", user.getRole());

        String role = user.getRole();
        if (role.equalsIgnoreCase("doctor")) {
            return "redirect:/doctor/dashboard";
        } else if (role.equalsIgnoreCase("patient")) {
            return "redirect:/patient/dashboard";
        } else if (role.equalsIgnoreCase("admin")) {
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Unknown role assigned to user.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
