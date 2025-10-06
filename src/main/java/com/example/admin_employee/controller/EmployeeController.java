package com.example.admin_employee.controller;

import com.example.admin_employee.model.Employee;
import com.example.admin_employee.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // ✅ Get logged-in employee details
    @GetMapping("/me")
    public ResponseEntity<Employee> getMyDetails(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        Employee employee = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return ResponseEntity.ok(employee);
    }

    // ✅ Update only phone + address
    @PutMapping("/me")
    public ResponseEntity<Employee> updateMyDetails(Authentication authentication, @RequestBody Employee updated) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        Employee employee = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Only allow phone + address update
        employee.setPhoneNumber(updated.getPhoneNumber());
        employee.setAddress(updated.getAddress());

        repository.save(employee);
        return ResponseEntity.ok(employee);
    }
}
