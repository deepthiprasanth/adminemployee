// EmployeeResponseDTO.java
package com.example.admin_employee.dto;

import com.example.admin_employee.model.Employee;

public class EmployeeResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String branch;
    private Employee.Role role;

    public EmployeeResponseDTO(Employee emp) {
        this.id = emp.getId();
        this.fullName = emp.getFullName();
        this.email = emp.getEmail();
        this.phoneNumber = emp.getPhoneNumber();
        this.branch = emp.getBranch();
        this.role = emp.getRole();
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getBranch() { return branch; }
    public Employee.Role getRole() { return role; }
}
