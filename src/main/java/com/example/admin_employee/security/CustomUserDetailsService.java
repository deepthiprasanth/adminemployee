                                      
package com.example.admin_employee.security;

import com.example.admin_employee.model.Employee;
import com.example.admin_employee.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Employee emp = employeeRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        // ✅ Just pass the enum name (e.g., "ADMIN" or "USER")
//        return User.builder()
//                .username(emp.getEmail())
//                .password(emp.getPassword())
//                .roles(emp.getRole().name()) // Spring automatically adds ROLE_
//                .build();
//    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        return User.builder()
            .username(employee.getEmail())
            .password(employee.getPassword())
            .roles(employee.getRole().name()) // Spring adds "ROLE_" automatically
            .build();
    }

}
