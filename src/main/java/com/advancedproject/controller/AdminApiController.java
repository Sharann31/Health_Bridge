package com.advancedproject.controller;

import com.advancedproject.model.*;
import com.advancedproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {

    @Autowired private UserRepository userRepo;
    @Autowired private AppointmentRepository appointmentRepo;

    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return "User deleted";
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }
}
