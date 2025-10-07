package com.example.admin_employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "occupational_details")
public class OccupationalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employmentType; // Mandatory
    private String shiftType;      // Mandatory
    private Boolean offerLetterSigned;
    private String offerLetterFile;
    private Boolean hasPassportPhoto;
    private String passportPhotoFile;

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

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public Boolean getOfferLetterSigned() {
        return offerLetterSigned;
    }

    public void setOfferLetterSigned(Boolean offerLetterSigned) {
        this.offerLetterSigned = offerLetterSigned;
    }

    public String getOfferLetterFile() {
        return offerLetterFile;
    }

    public void setOfferLetterFile(String offerLetterFile) {
        this.offerLetterFile = offerLetterFile;
    }

    public Boolean getHasPassportPhoto() {
        return hasPassportPhoto;
    }

    public void setHasPassportPhoto(Boolean hasPassportPhoto) {
        this.hasPassportPhoto = hasPassportPhoto;
    }

    public String getPassportPhotoFile() {
        return passportPhotoFile;
    }

    public void setPassportPhotoFile(String passportPhotoFile) {
        this.passportPhotoFile = passportPhotoFile;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
