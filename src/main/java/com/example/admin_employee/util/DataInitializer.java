package com.example.admin_employee.util;

import com.example.admin_employee.model.Employee;
import com.example.admin_employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // ✅ Check if superadmin already exists by email
        if (employeeRepository.findByEmail("superadmin@gmail.com").isEmpty()) {

            Employee superAdmin = new Employee();
            superAdmin.setFullName("Super Admin");
            superAdmin.setPhoneNumber("9999999999");
            superAdmin.setEmail("superadmin@gmail.com");

            // ✅ Encode the password before saving
            superAdmin.setPassword(passwordEncoder.encode("supersecret"));

            // ✅ Role (assuming enum)
            superAdmin.setRole(Employee.Role.ADMIN);

            // ✅ Optional: Branch field (add default)
            superAdmin.setBranch("Head Office");

            // ✅ Confirm password not needed for DB, skip it
            // superAdmin.setConfirmPassword(null);

            employeeRepository.save(superAdmin);
            System.out.println("✅ Super admin created successfully!");
        } else {
            System.out.println("ℹ️ Super admin already exists.");
        }
    }
}
