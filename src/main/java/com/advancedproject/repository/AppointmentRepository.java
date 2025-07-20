package com.advancedproject.repository;

import com.advancedproject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorUsername(String doctorUsername);
    List<Appointment> findByPatientUsername(String patientUsername);
    List<Appointment> findByStatus(String status);
}
