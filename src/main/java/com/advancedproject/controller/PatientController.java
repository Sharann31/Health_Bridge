package com.advancedproject.controller;

import com.advancedproject.model.Appointment;
import com.advancedproject.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import com.advancedproject.model.MedicalRecord;
import com.advancedproject.repository.MedicalRecordRepository;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	@GetMapping("/dashboard")
	public String showPatientDashboard(HttpSession session, Model model) {
	    String patientUsername = (String) session.getAttribute("loggedInUsername");

	    if (patientUsername == null) {
	        return "redirect:/login";
	    }

	    // ✅ Fetch medical records from DB
	    List<MedicalRecord> records = medicalRecordRepository.findByPatientUsername(patientUsername);
	    model.addAttribute("records", records);

	    return "patient-dashboard";
	}


    @Autowired
    private AppointmentRepository appointmentRepository;

    // Show the patient dashboard page
    //@GetMapping("/dashboard")
    //public String showPatientDashboard() {
        //return "patient-dashboard";
    //}

    // Handle booking appointment form submission
    @PostMapping("/book-appointment")
    public String bookAppointment(@RequestParam String doctorUsername,
                                  @RequestParam String appointmentDate,
                                  @RequestParam String appointmentTime,
                                  @RequestParam String patientEmail,
                                  HttpSession session,
                                  Model model) {

        String patientUsername = (String) session.getAttribute("loggedInUsername");

        if (patientUsername == null) {
            return "redirect:/login";
        }

        Appointment appointment = new Appointment();
        appointment.setDoctorUsername(doctorUsername);
        appointment.setPatientUsername(patientUsername);
        appointment.setAppointmentDate(LocalDate.parse(appointmentDate));  // ✅ Proper conversion
        appointment.setAppointmentTime(LocalTime.parse(appointmentTime));  // ✅ Proper conversion
        appointment.setStatus("PENDING");
        appointment.setPatientEmail(patientEmail);

        appointmentRepository.save(appointment);

        model.addAttribute("message", "Appointment booked successfully!");
        return "patient-dashboard";
    }
}



