package com.example.admin_employee.security;

import com.example.admin_employee.model.Employee;
import com.example.admin_employee.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Find employee by email instead of username
        Employee emp = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Return a Spring Security UserDetails object
        return User.builder()
                .username(emp.getEmail())                // Use email as username
                .password(emp.getPassword())             // Hashed password from DB
                .roles(emp.getRole().name())             // Automatically adds ROLE_ prefix
                .build();
    }
}
