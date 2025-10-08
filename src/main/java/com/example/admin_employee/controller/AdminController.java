package com.example.admin_employee.controller;

import com.example.admin_employee.dto.EmployeeDTO;
import com.example.admin_employee.dto.EmployeeResponseDTO;
import com.example.admin_employee.model.Employee;
import com.example.admin_employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final EmployeeService employeeService;

    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ================= Create Employee with files =================
    @PostMapping(value = "/employees", consumes = {"multipart/form-data"})
    public ResponseEntity<Employee> addEmployee(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam(required = false) String confirmPassword,
            @RequestParam String phoneNumber,
            @RequestParam String branch,
            @RequestParam Employee.Role role,

            // ProfessionalDetails
            @RequestParam(required = false) String highestQualification,
            @RequestParam(required = false) String institution,
            @RequestParam(required = false) Integer yearOfPassing,
            @RequestParam(required = false) String technicalCertificates,
            @RequestParam(required = false) String previousEmployers,
            @RequestParam(required = false) String employmentStartDate,
            @RequestParam(required = false) String employmentEndDate,
            @RequestParam(required = false) String reasonOfLeaving,
            @RequestParam(required = false) Double totalExperience,
            @RequestParam(required = false) String areasOfExpertise,
            @RequestPart(required = false) MultipartFile qualificationCertificateFile,
            @RequestPart(required = false) MultipartFile certificateFile,
            @RequestPart(required = false) MultipartFile relievingLetterFile,

            // OccupationalDetails
            @RequestParam(required = false) String employmentType,
            @RequestParam(required = false) String shiftType,
            @RequestParam(required = false) Boolean offerLetterSigned,
            @RequestPart(required = false) MultipartFile offerLetterFile,
            @RequestParam(required = false) Boolean hasPassportPhoto,
            @RequestPart(required = false) MultipartFile passportPhotoFile,

            // PersonalDetails
            @RequestParam(required = false) String dateOfBirth,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String bloodGroup,
            @RequestParam(required = false) String maritalStatus,
            @RequestParam(required = false) String nationality,
            @RequestParam(required = false) String aadharNumber,
            @RequestParam(required = false) String panNumber,
            @RequestParam(required = false) String personalEmail,
            @RequestParam(required = false) String permanentAddress,
            @RequestParam(required = false) String communicationAddress,
            @RequestParam(required = false) String emergencyContactPerson,
            @RequestParam(required = false) String relationship,
            @RequestParam(required = false) String contactNumber,
            @RequestPart(required = false) MultipartFile aadharFile,
            @RequestPart(required = false) MultipartFile panFile,

            // SalaryDetails
            @RequestParam(required = false) Double basicPay,
            @RequestParam(required = false) Double hra,
            @RequestParam(required = false) Double conveyanceAllowance,
            @RequestParam(required = false) Double specialAllowance,
            @RequestParam(required = false) Double incentivePercent,
            @RequestParam(required = false) Double grossSalary,
            @RequestParam(required = false) Double pfDeduction,
            @RequestParam(required = false) Double esiDeduction,
            @RequestParam(required = false) Double totalDeductions,
            @RequestParam(required = false) Double netSalary,
            @RequestParam(required = false) String paymentMode,
            @RequestParam(required = false) String bankName,
            @RequestParam(required = false) String bankAccountNumber,
            @RequestParam(required = false) String ifscCode,
            @RequestPart(required = false) MultipartFile cancelledChequeFile
    ) {

        // Build DTO
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFullName(fullName);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setConfirmPassword(confirmPassword);
        dto.setPhoneNumber(phoneNumber);
        dto.setBranch(branch);
        dto.setRole(role);

        // ProfessionalDetails
        EmployeeDTO.ProfessionalDetailsDTO prof = new EmployeeDTO.ProfessionalDetailsDTO();
        prof.setHighestQualification(highestQualification);
        prof.setInstitution(institution);
        prof.setYearOfPassing(yearOfPassing);
        prof.setTechnicalCertificates(technicalCertificates);
        prof.setPreviousEmployers(previousEmployers);
        prof.setEmploymentStartDate(employmentStartDate != null ? java.time.LocalDate.parse(employmentStartDate) : null);
        prof.setEmploymentEndDate(employmentEndDate != null ? java.time.LocalDate.parse(employmentEndDate) : null);
        prof.setReasonOfLeaving(reasonOfLeaving);
        prof.setTotalExperience(totalExperience);
        prof.setAreasOfExpertise(areasOfExpertise);
        prof.setQualificationCertificateFile(qualificationCertificateFile);
        prof.setCertificateFile(certificateFile);
        prof.setRelievingLetterFile(relievingLetterFile);
        dto.setProfessionalDetails(prof);

        // OccupationalDetails
        EmployeeDTO.OccupationalDetailsDTO occ = new EmployeeDTO.OccupationalDetailsDTO();
        occ.setEmploymentType(employmentType);
        occ.setShiftType(shiftType);
        occ.setOfferLetterSigned(offerLetterSigned);
        occ.setOfferLetterFile(offerLetterFile);
        occ.setHasPassportPhoto(hasPassportPhoto);
        occ.setPassportPhotoFile(passportPhotoFile);
        dto.setOccupationalDetails(occ);

        // PersonalDetails
        EmployeeDTO.PersonalDetailsDTO personal = new EmployeeDTO.PersonalDetailsDTO();
        personal.setDateOfBirth(dateOfBirth != null ? java.time.LocalDate.parse(dateOfBirth) : null);
        personal.setGender(gender);
        personal.setBloodGroup(bloodGroup);
        personal.setMaritalStatus(maritalStatus);
        personal.setNationality(nationality);
        personal.setAadharNumber(aadharNumber);
        personal.setPanNumber(panNumber);
        personal.setPersonalEmail(personalEmail);
        personal.setPermanentAddress(permanentAddress);
        personal.setCommunicationAddress(communicationAddress);
        personal.setEmergencyContactPerson(emergencyContactPerson);
        personal.setRelationship(relationship);
        personal.setContactNumber(contactNumber);
        personal.setAadharFile(aadharFile);
        personal.setPanFile(panFile);
        dto.setPersonalDetails(personal);

        // SalaryDetails
        EmployeeDTO.SalaryDetailsDTO salary = new EmployeeDTO.SalaryDetailsDTO();
        salary.setBasicPay(basicPay);
        salary.setHra(hra);
        salary.setConveyanceAllowance(conveyanceAllowance);
        salary.setSpecialAllowance(specialAllowance);
        salary.setIncentivePercent(incentivePercent);
        salary.setGrossSalary(grossSalary);
        salary.setPfDeduction(pfDeduction);
        salary.setEsiDeduction(esiDeduction);
        salary.setTotalDeductions(totalDeductions);
        salary.setNetSalary(netSalary);
        salary.setPaymentMode(paymentMode);
        salary.setBankName(bankName);
        salary.setBankAccountNumber(bankAccountNumber);
        salary.setIfscCode(ifscCode);
        salary.setCancelledChequeFile(cancelledChequeFile);
        dto.setSalaryDetails(salary);

        // Save
        Employee saved = employeeService.saveEmployee(dto);
        return ResponseEntity.ok(saved);
    }

    // ================ Other CRUD endpoints ==================
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();

        // Filter out ADMINs and map to DTO
        List<EmployeeResponseDTO> response = employees.stream()
            .filter(emp -> emp.getRole() != Employee.Role.ADMIN)
            .map(EmployeeResponseDTO::new)
            .toList();

        return ResponseEntity.ok(response);
    }


    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @ModelAttribute EmployeeDTO dto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}