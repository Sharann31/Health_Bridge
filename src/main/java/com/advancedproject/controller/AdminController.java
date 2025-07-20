package com.advancedproject.controller;

import com.advancedproject.model.User;
import com.advancedproject.model.Appointment;
import com.advancedproject.repository.UserRepository;
import com.advancedproject.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    // ✅ 1. Show Admin Dashboard with all users
    @GetMapping("/dashboard")
    public String showAdminDashboard(Model model) {
        List<User> allUsers = userRepository.findAll();
        model.addAttribute("users", allUsers);
        return "admin-dashboard";
    }

    // ✅ 2. Delete a user by ID
    @GetMapping("/delete-user")
    public String deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/dashboard";
    }

    // ✅ 3. Show all appointments with optional status filter
    @GetMapping("/appointments")
    public String viewAllAppointments(@RequestParam(required = false) String status, Model model) {
        List<Appointment> appointments;

        if (status != null && !status.isEmpty()) {
            appointments = appointmentRepository.findByStatus(status.toUpperCase());
        } else {
            appointments = appointmentRepository.findAll();
        }

        model.addAttribute("appointments", appointments);
        model.addAttribute("selectedStatus", status);

        return "admin-appointments";
    }
}
