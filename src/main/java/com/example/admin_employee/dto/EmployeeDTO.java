
package com.example.admin_employee.dto;

import com.example.admin_employee.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class EmployeeDTO {

    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;
    private Employee.Role role;
    private String branch;

    private ProfessionalDetailsDTO professionalDetails;
    private OccupationalDetailsDTO occupationalDetails;
    private PersonalDetailsDTO personalDetails;
    private SalaryDetailsDTO salaryDetails;

    // ===== Getters & Setters for EmployeeDTO =====
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public Employee.Role getRole() { return role; }
    public void setRole(Employee.Role role) { this.role = role; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public ProfessionalDetailsDTO getProfessionalDetails() { return professionalDetails; }
    public void setProfessionalDetails(ProfessionalDetailsDTO professionalDetails) { this.professionalDetails = professionalDetails; }

    public OccupationalDetailsDTO getOccupationalDetails() { return occupationalDetails; }
    public void setOccupationalDetails(OccupationalDetailsDTO occupationalDetails) { this.occupationalDetails = occupationalDetails; }

    public PersonalDetailsDTO getPersonalDetails() { return personalDetails; }
    public void setPersonalDetails(PersonalDetailsDTO personalDetails) { this.personalDetails = personalDetails; }

    public SalaryDetailsDTO getSalaryDetails() { return salaryDetails; }
    public void setSalaryDetails(SalaryDetailsDTO salaryDetails) { this.salaryDetails = salaryDetails; }

    // ===== Nested DTOs =====
    public static class ProfessionalDetailsDTO {
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

        private MultipartFile qualificationCertificateFile;
        private MultipartFile certificateFile;
        private MultipartFile relievingLetterFile;

        // Getters & Setters
        public String getHighestQualification() { return highestQualification; }
        public void setHighestQualification(String highestQualification) { this.highestQualification = highestQualification; }

        public String getInstitution() { return institution; }
        public void setInstitution(String institution) { this.institution = institution; }

        public Integer getYearOfPassing() { return yearOfPassing; }
        public void setYearOfPassing(Integer yearOfPassing) { this.yearOfPassing = yearOfPassing; }

        public String getTechnicalCertificates() { return technicalCertificates; }
        public void setTechnicalCertificates(String technicalCertificates) { this.technicalCertificates = technicalCertificates; }

        public String getPreviousEmployers() { return previousEmployers; }
        public void setPreviousEmployers(String previousEmployers) { this.previousEmployers = previousEmployers; }

        public LocalDate getEmploymentStartDate() { return employmentStartDate; }
        public void setEmploymentStartDate(LocalDate employmentStartDate) { this.employmentStartDate = employmentStartDate; }

        public LocalDate getEmploymentEndDate() { return employmentEndDate; }
        public void setEmploymentEndDate(LocalDate employmentEndDate) { this.employmentEndDate = employmentEndDate; }

        public String getReasonOfLeaving() { return reasonOfLeaving; }
        public void setReasonOfLeaving(String reasonOfLeaving) { this.reasonOfLeaving = reasonOfLeaving; }

        public Double getTotalExperience() { return totalExperience; }
        public void setTotalExperience(Double totalExperience) { this.totalExperience = totalExperience; }

        public String getAreasOfExpertise() { return areasOfExpertise; }
        public void setAreasOfExpertise(String areasOfExpertise) { this.areasOfExpertise = areasOfExpertise; }

        public MultipartFile getQualificationCertificateFile() { return qualificationCertificateFile; }
        public void setQualificationCertificateFile(MultipartFile qualificationCertificateFile) { this.qualificationCertificateFile = qualificationCertificateFile; }

        public MultipartFile getCertificateFile() { return certificateFile; }
        public void setCertificateFile(MultipartFile certificateFile) { this.certificateFile = certificateFile; }

        public MultipartFile getRelievingLetterFile() { return relievingLetterFile; }
        public void setRelievingLetterFile(MultipartFile relievingLetterFile) { this.relievingLetterFile = relievingLetterFile; }
    }

    public static class OccupationalDetailsDTO {
        private String employmentType;
        private String shiftType;
        private Boolean offerLetterSigned;
        private MultipartFile offerLetterFile;
        private Boolean hasPassportPhoto;
        private MultipartFile passportPhotoFile;

        // Getters & Setters
        public String getEmploymentType() { return employmentType; }
        public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }

        public String getShiftType() { return shiftType; }
        public void setShiftType(String shiftType) { this.shiftType = shiftType; }

        public Boolean getOfferLetterSigned() { return offerLetterSigned; }
        public void setOfferLetterSigned(Boolean offerLetterSigned) { this.offerLetterSigned = offerLetterSigned; }

        public MultipartFile getOfferLetterFile() { return offerLetterFile; }
        public void setOfferLetterFile(MultipartFile offerLetterFile) { this.offerLetterFile = offerLetterFile; }

        public Boolean getHasPassportPhoto() { return hasPassportPhoto; }
        public void setHasPassportPhoto(Boolean hasPassportPhoto) { this.hasPassportPhoto = hasPassportPhoto; }

        public MultipartFile getPassportPhotoFile() { return passportPhotoFile; }
        public void setPassportPhotoFile(MultipartFile passportPhotoFile) { this.passportPhotoFile = passportPhotoFile; }
    }

    public static class PersonalDetailsDTO {
        private LocalDate dateOfBirth;
        private String gender;
        private String bloodGroup;
        private String maritalStatus;
        private String nationality;
        private String aadharNumber;
        private String panNumber;
        private String personalEmail;
        private String permanentAddress;
        private String communicationAddress;
        private String emergencyContactPerson;
        private String relationship;
        private String contactNumber;

        private MultipartFile aadharFile;
        private MultipartFile panFile;

        // Getters & Setters
        public LocalDate getDateOfBirth() { return dateOfBirth; }
        public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }

        public String getBloodGroup() { return bloodGroup; }
        public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

        public String getMaritalStatus() { return maritalStatus; }
        public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

        public String getNationality() { return nationality; }
        public void setNationality(String nationality) { this.nationality = nationality; }

        public String getAadharNumber() { return aadharNumber; }
        public void setAadharNumber(String aadharNumber) { this.aadharNumber = aadharNumber; }

        public String getPanNumber() { return panNumber; }
        public void setPanNumber(String panNumber) { this.panNumber = panNumber; }

        public String getPersonalEmail() { return personalEmail; }
        public void setPersonalEmail(String personalEmail) { this.personalEmail = personalEmail; }

        public String getPermanentAddress() { return permanentAddress; }
        public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

        public String getCommunicationAddress() { return communicationAddress; }
        public void setCommunicationAddress(String communicationAddress) { this.communicationAddress = communicationAddress; }

        public String getEmergencyContactPerson() { return emergencyContactPerson; }
        public void setEmergencyContactPerson(String emergencyContactPerson) { this.emergencyContactPerson = emergencyContactPerson; }

        public String getRelationship() { return relationship; }
        public void setRelationship(String relationship) { this.relationship = relationship; }

        public String getContactNumber() { return contactNumber; }
        public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

        public MultipartFile getAadharFile() { return aadharFile; }
        public void setAadharFile(MultipartFile aadharFile) { this.aadharFile = aadharFile; }

        public MultipartFile getPanFile() { return panFile; }
        public void setPanFile(MultipartFile panFile) { this.panFile = panFile; }
    }

    public static class SalaryDetailsDTO {
        private Double basicPay;
        private Double hra;
        private Double conveyanceAllowance;
        private Double specialAllowance;
        private Double incentivePercent;
        private Double grossSalary;
        private Double pfDeduction;
        private Double esiDeduction;
        private Double totalDeductions;
        private Double netSalary;
        private String paymentMode;
        private String bankName;
        private String bankAccountNumber;
        private String ifscCode;

        private MultipartFile cancelledChequeFile;

        // Getters & Setters
        public Double getBasicPay() { return basicPay; }
        public void setBasicPay(Double basicPay) { this.basicPay = basicPay; }

        public Double getHra() { return hra; }
        public void setHra(Double hra) { this.hra = hra; }

        public Double getConveyanceAllowance() { return conveyanceAllowance; }
        public void setConveyanceAllowance(Double conveyanceAllowance) { this.conveyanceAllowance = conveyanceAllowance; }

        public Double getSpecialAllowance() { return specialAllowance; }
        public void setSpecialAllowance(Double specialAllowance) { this.specialAllowance = specialAllowance; }

        public Double getIncentivePercent() { return incentivePercent; }
        public void setIncentivePercent(Double incentivePercent) { this.incentivePercent = incentivePercent; }

        public Double getGrossSalary() { return grossSalary; }
        public void setGrossSalary(Double grossSalary) { this.grossSalary = grossSalary; }

        public Double getPfDeduction() { return pfDeduction; }
        public void setPfDeduction(Double pfDeduction) { this.pfDeduction = pfDeduction; }

        public Double getEsiDeduction() { return esiDeduction; }
        public void setEsiDeduction(Double esiDeduction) { this.esiDeduction = esiDeduction; }

        public Double getTotalDeductions() { return totalDeductions; }
        public void setTotalDeductions(Double totalDeductions) { this.totalDeductions = totalDeductions; }

        public Double getNetSalary() { return netSalary; }
        public void setNetSalary(Double netSalary) { this.netSalary = netSalary; }

        public String getPaymentMode() { return paymentMode; }
        public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

        public String getBankName() { return bankName; }
        public void setBankName(String bankName) { this.bankName = bankName; }

        public String getBankAccountNumber() { return bankAccountNumber; }
        public void setBankAccountNumber(String bankAccountNumber) { this.bankAccountNumber = bankAccountNumber; }

        public String getIfscCode() { return ifscCode; }
        public void setIfscCode(String ifscCode) { this.ifscCode = ifscCode; }

        public MultipartFile getCancelledChequeFile() { return cancelledChequeFile; }
        public void setCancelledChequeFile(MultipartFile cancelledChequeFile) { this.cancelledChequeFile = cancelledChequeFile; }
    }
}
