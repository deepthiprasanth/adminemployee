package com.example.admin_employee.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.admin_employee.model.Employee;
import com.example.admin_employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Check if superadmin already exists
        if (employeeRepository.findByUsername("superadmin").isEmpty()) {

            Employee superAdmin = new Employee();
            superAdmin.setName("SuperAdmin");
            superAdmin.setEmail("superadmin@gmail.com");
            superAdmin.setUsername("superadmin");
            superAdmin.setPassword(passwordEncoder.encode("supersecret")); // plain password here
            superAdmin.setDepartment("IT");
            superAdmin.setRole(Employee.Role.ADMIN); // ✅ enum value
            superAdmin.setSalary(100000.0); //

            employeeRepository.save(superAdmin);
            System.out.println("Super admin created successfully!");
        }
    }
}
