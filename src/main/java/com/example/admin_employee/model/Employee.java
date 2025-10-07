package com.example.admin_employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;

    @Transient
    private String confirmPassword; // Not mandatory

    @Enumerated(EnumType.STRING)
    private Role role;

    private String branch;

    // One-to-one relationships
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private ProfessionalDetails professionalDetails;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private OccupationalDetails occupationalDetails;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private PersonalDetails personalDetails;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private SalaryDetails salaryDetails;

    // Enum for role
    public enum Role {
        ADMIN, USER
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public ProfessionalDetails getProfessionalDetails() {
        return professionalDetails;
    }

    public void setProfessionalDetails(ProfessionalDetails professionalDetails) {
        this.professionalDetails = professionalDetails;
    }

    public OccupationalDetails getOccupationalDetails() {
        return occupationalDetails;
    }

    public void setOccupationalDetails(OccupationalDetails occupationalDetails) {
        this.occupationalDetails = occupationalDetails;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public SalaryDetails getSalaryDetails() {
        return salaryDetails;
    }

    public void setSalaryDetails(SalaryDetails salaryDetails) {
        this.salaryDetails = salaryDetails;
    }
}
