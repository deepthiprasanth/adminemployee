package com.example.admin_employee.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "professional_details")
public class ProfessionalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String highestQualification;
    private String institution;
    private Integer yearOfPassing;
    private String technicalCertificates;
    private String previousEmployers;
    private LocalDate employmentStartDate;
    private LocalDate employmentEndDate;
    private String reasonOfLeaving;
    private Double totalExperience;
    private String areasOfExpertise;
    private String qualificationCertificateFile;
    private String certificateFile;
    private String relievingLetterFile;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(Integer yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public String getTechnicalCertificates() {
        return technicalCertificates;
    }

    public void setTechnicalCertificates(String technicalCertificates) {
        this.technicalCertificates = technicalCertificates;
    }

    public String getPreviousEmployers() {
        return previousEmployers;
    }

    public void setPreviousEmployers(String previousEmployers) {
        this.previousEmployers = previousEmployers;
    }

    public LocalDate getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setEmploymentStartDate(LocalDate employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    public LocalDate getEmploymentEndDate() {
        return employmentEndDate;
    }

    public void setEmploymentEndDate(LocalDate employmentEndDate) {
        this.employmentEndDate = employmentEndDate;
    }

    public String getReasonOfLeaving() {
        return reasonOfLeaving;
    }

    public void setReasonOfLeaving(String reasonOfLeaving) {
        this.reasonOfLeaving = reasonOfLeaving;
    }

    public Double getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Double totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getAreasOfExpertise() {
        return areasOfExpertise;
    }

    public void setAreasOfExpertise(String areasOfExpertise) {
        this.areasOfExpertise = areasOfExpertise;
    }

    public String getQualificationCertificateFile() {
        return qualificationCertificateFile;
    }

    public void setQualificationCertificateFile(String qualificationCertificateFile) {
        this.qualificationCertificateFile = qualificationCertificateFile;
    }

    public String getCertificateFile() {
        return certificateFile;
    }

    public void setCertificateFile(String certificateFile) {
        this.certificateFile = certificateFile;
    }

    public String getRelievingLetterFile() {
        return relievingLetterFile;
    }

    public void setRelievingLetterFile(String relievingLetterFile) {
        this.relievingLetterFile = relievingLetterFile;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}