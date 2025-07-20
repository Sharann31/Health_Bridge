package com.advancedproject.model;

import javax.persistence.*;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientUsername;
    private String doctorUsername;
    private String diagnosis;
    private String treatment;
    private String notes;

    public MedicalRecord() {}

    public MedicalRecord(String patientUsername, String doctorUsername,
                         String diagnosis, String treatment, String notes) {
        this.patientUsername = patientUsername;
        this.doctorUsername = doctorUsername;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPatientUsername() { return patientUsername; }
    public void setPatientUsername(String patientUsername) { this.patientUsername = patientUsername; }
    public String getDoctorUsername() { return doctorUsername; }
    public void setDoctorUsername(String doctorUsername) { this.doctorUsername = doctorUsername; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
