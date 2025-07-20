package com.advancedproject.repository;

import com.advancedproject.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPatientUsername(String patientUsername);
    List<MedicalRecord> findByDoctorUsername(String doctorUsername);
}
