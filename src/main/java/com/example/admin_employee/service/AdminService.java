package com.example.admin_employee.service;

import com.example.admin_employee.model.Employee;
import com.example.admin_employee.model.Employee.Role;
import com.example.admin_employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final EmployeeRepository employeeRepository;

    public AdminService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Admin can view all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Admin can delete employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Admin can promote employee
    public Employee promoteToAdmin(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setRole(Role.ADMIN); // ✅ set role to ADMIN
        return employeeRepository.save(employee); // ✅ persist and return updated employee
    }
}
