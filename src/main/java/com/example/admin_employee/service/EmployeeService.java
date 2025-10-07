package com.example.admin_employee.service;

import com.example.admin_employee.dto.EmployeeDTO;
import com.example.admin_employee.model.*;
import com.example.admin_employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final String uploadDir = "uploads/";

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(EmployeeDTO dto) {
        try {
            Employee emp = mapDtoToEntity(dto);
            return employeeRepository.save(emp);
        } catch (IOException e) {
            throw new RuntimeException("File upload error: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee existing = getEmployeeById(id);
        try {
            Employee updated = mapDtoToEntity(dto);
            updated.setId(existing.getId());
            return employeeRepository.save(updated);
        } catch (IOException e) {
            throw new RuntimeException("File upload error: " + e.getMessage());
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // ===== Mapping DTO to Entity =====
    private Employee mapDtoToEntity(EmployeeDTO dto) throws IOException {
        Employee emp = new Employee();
        emp.setFullName(dto.getFullName());
        emp.setEmail(dto.getEmail());
        emp.setPhoneNumber(dto.getPhoneNumber());
        emp.setPassword(dto.getPassword());
        emp.setBranch(dto.getBranch());
        emp.setRole(dto.getRole());

        // Professional
        ProfessionalDetails prof = new ProfessionalDetails();
        prof.setHighestQualification(dto.getProfessionalDetails().getHighestQualification());
        prof.setInstitution(dto.getProfessionalDetails().getInstitution());
        prof.setYearOfPassing(dto.getProfessionalDetails().getYearOfPassing());
        prof.setTechnicalCertificates(dto.getProfessionalDetails().getTechnicalCertificates());
        prof.setPreviousEmployers(dto.getProfessionalDetails().getPreviousEmployers());
        prof.setEmploymentStartDate(dto.getProfessionalDetails().getEmploymentStartDate());
        prof.setEmploymentEndDate(dto.getProfessionalDetails().getEmploymentEndDate());
        prof.setReasonOfLeaving(dto.getProfessionalDetails().getReasonOfLeaving());
        prof.setTotalExperience(dto.getProfessionalDetails().getTotalExperience());
        prof.setAreasOfExpertise(dto.getProfessionalDetails().getAreasOfExpertise());
        prof.setQualificationCertificateFile(saveFile(dto.getProfessionalDetails().getQualificationCertificateFile()));
        prof.setCertificateFile(saveFile(dto.getProfessionalDetails().getCertificateFile()));
        prof.setRelievingLetterFile(saveFile(dto.getProfessionalDetails().getRelievingLetterFile()));
        prof.setEmployee(emp);
        emp.setProfessionalDetails(prof);

        // Occupational
        OccupationalDetails occ = new OccupationalDetails();
        occ.setEmploymentType(dto.getOccupationalDetails().getEmploymentType());
        occ.setShiftType(dto.getOccupationalDetails().getShiftType());
        occ.setOfferLetterSigned(dto.getOccupationalDetails().getOfferLetterSigned());
        occ.setOfferLetterFile(saveFile(dto.getOccupationalDetails().getOfferLetterFile()));
        occ.setHasPassportPhoto(dto.getOccupationalDetails().getHasPassportPhoto());
        occ.setPassportPhotoFile(saveFile(dto.getOccupationalDetails().getPassportPhotoFile()));
        occ.setEmployee(emp);
        emp.setOccupationalDetails(occ);

        // Personal
        PersonalDetails personal = new PersonalDetails();
        personal.setDateOfBirth(dto.getPersonalDetails().getDateOfBirth());
        personal.setGender(dto.getPersonalDetails().getGender());
        personal.setBloodGroup(dto.getPersonalDetails().getBloodGroup());
        personal.setMaritalStatus(dto.getPersonalDetails().getMaritalStatus());
        personal.setNationality(dto.getPersonalDetails().getNationality());
        personal.setAadharNumber(dto.getPersonalDetails().getAadharNumber());
        personal.setPanNumber(dto.getPersonalDetails().getPanNumber());
        personal.setPersonalEmail(dto.getPersonalDetails().getPersonalEmail());
        personal.setPermanentAddress(dto.getPersonalDetails().getPermanentAddress());
        personal.setCommunicationAddress(dto.getPersonalDetails().getCommunicationAddress());
        personal.setEmergencyContactPerson(dto.getPersonalDetails().getEmergencyContactPerson());
        personal.setRelationship(dto.getPersonalDetails().getRelationship());
        personal.setContactNumber(dto.getPersonalDetails().getContactNumber());
        personal.setAadharFile(saveFile(dto.getPersonalDetails().getAadharFile()));
        personal.setPanFile(saveFile(dto.getPersonalDetails().getPanFile()));
        personal.setEmployee(emp);
        emp.setPersonalDetails(personal);

        // Salary
        SalaryDetails salary = new SalaryDetails();
        salary.setBasicPay(dto.getSalaryDetails().getBasicPay());
        salary.setHra(dto.getSalaryDetails().getHra());
        salary.setConveyanceAllowance(dto.getSalaryDetails().getConveyanceAllowance());
        salary.setSpecialAllowance(dto.getSalaryDetails().getSpecialAllowance());
        salary.setIncentivePercent(dto.getSalaryDetails().getIncentivePercent());
        salary.setGrossSalary(dto.getSalaryDetails().getGrossSalary());
        salary.setPfDeduction(dto.getSalaryDetails().getPfDeduction());
        salary.setEsiDeduction(dto.getSalaryDetails().getEsiDeduction());
        salary.setTotalDeductions(dto.getSalaryDetails().getTotalDeductions());
        salary.setNetSalary(dto.getSalaryDetails().getNetSalary());
        salary.setPaymentMode(dto.getSalaryDetails().getPaymentMode());
        salary.setBankName(dto.getSalaryDetails().getBankName());
        salary.setBankAccountNumber(dto.getSalaryDetails().getBankAccountNumber());
        salary.setIfscCode(dto.getSalaryDetails().getIfscCode());
        salary.setCancelledChequeFile(saveFile(dto.getSalaryDetails().getCancelledChequeFile()));
        salary.setEmployee(emp);
        emp.setSalaryDetails(salary);

        return emp;
    }

    // ===== Save file utility =====
    private String saveFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) return null;
        String filename = System.currentTimeMillis() + "_" + StringUtils.cleanPath(file.getOriginalFilename());
        File dest = new File(uploadDir + filename);
        dest.getParentFile().mkdirs();
        file.transferTo(dest);
        return dest.getAbsolutePath();
    }
}
