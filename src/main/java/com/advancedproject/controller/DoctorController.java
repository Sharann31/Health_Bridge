package com.advancedproject.controller;

import com.advancedproject.model.Appointment;
import com.advancedproject.model.MedicalRecord;
import com.advancedproject.model.User;
import com.advancedproject.repository.AppointmentRepository;
import com.advancedproject.repository.MedicalRecordRepository;
import com.advancedproject.repository.UserRepository;
import com.advancedproject.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String showDoctorDashboard(HttpSession session, Model model) {
        String doctorUsername = (String) session.getAttribute("loggedInUsername");
        if (doctorUsername == null) {
            return "redirect:/login";
        }
        List<Appointment> appointments = appointmentRepository.findByDoctorUsername(doctorUsername);
        List<MedicalRecord> records = medicalRecordRepository.findByDoctorUsername(doctorUsername);
        model.addAttribute("appointments", appointments);
        model.addAttribute("records", records);
        return "doctor-dashboard";
    }

    @PostMapping("/update-status")
    public String updateAppointmentStatus(@RequestParam Long appointmentId,
                                          @RequestParam String status,
                                          HttpSession session) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            appointment.setStatus(status);
            appointmentRepository.save(appointment);

            // ✅ Email to Doctor
            String doctorUsername = appointment.getDoctorUsername();
            Optional<User> doctorOptional = userRepository.findByUsername(doctorUsername);
            User doctor = doctorOptional.orElse(null);
            if (doctor != null) {
                emailService.sendSimpleMessage(
                    doctor.getEmail(),
                    "Appointment Status Updated",
                    "Appointment with " + appointment.getPatientUsername() + " is " + status + "."
                );
            }

            // ✅ Email to Patient
            String patientUsername = appointment.getPatientUsername();
            Optional<User> patientOptional = userRepository.findByUsername(patientUsername);
            User patient = patientOptional.orElse(null);
            if (patient != null) {
                emailService.sendSimpleMessage(
                    patient.getEmail(),
                    "Your Appointment Status",
                    "Hello " + patientUsername + ", your appointment with Doctor "
                            + doctorUsername + " has been " + status + "."
                );
            }

        }
        return "redirect:/doctor/dashboard";
    }

    // Add Medical Record
    @GetMapping("/add-medical-record")
    public String showAddMedicalRecordForm() {
        return "add-medical-record";
    }

    @PostMapping("/add-medical-record")
    public String addMedicalRecord(@RequestParam String patientUsername,
                                   @RequestParam String diagnosis,
                                   @RequestParam String treatment,
                                   @RequestParam String notes,
                                   HttpSession session,
                                   Model model) {
        String doctorUsername = (String) session.getAttribute("loggedInUsername");
        if (doctorUsername == null) {
            return "redirect:/login";
        }

        MedicalRecord record = new MedicalRecord();
        record.setDoctorUsername(doctorUsername);
        record.setPatientUsername(patientUsername);
        record.setDiagnosis(diagnosis);
        record.setTreatment(treatment);
        record.setNotes(notes);

        medicalRecordRepository.save(record);

        model.addAttribute("message", "Medical Record Added Successfully!");
        return "redirect:/doctor/dashboard";
    }

    // Edit Medical Record
    @GetMapping("/edit-medical-record")
    public String editMedicalRecordForm(@RequestParam Long id, Model model) {
        Optional<MedicalRecord> optionalRecord = medicalRecordRepository.findById(id);
        if (optionalRecord.isPresent()) {
            model.addAttribute("record", optionalRecord.get());
            return "edit-medical-record";
        }
        return "redirect:/doctor/dashboard";
    }

    @PostMapping("/edit-medical-record")
    public String editMedicalRecord(@RequestParam Long id,
                                    @RequestParam String diagnosis,
                                    @RequestParam String treatment,
                                    @RequestParam String notes) {
        Optional<MedicalRecord> optionalRecord = medicalRecordRepository.findById(id);
        if (optionalRecord.isPresent()) {
            MedicalRecord record = optionalRecord.get();
            record.setDiagnosis(diagnosis);
            record.setTreatment(treatment);
            record.setNotes(notes);
            medicalRecordRepository.save(record);
        }
        return "redirect:/doctor/dashboard";
    }

    @GetMapping("/delete-medical-record")
    public String deleteMedicalRecord(@RequestParam Long id) {
        medicalRecordRepository.deleteById(id);
        return "redirect:/doctor/dashboard";
    }
}
