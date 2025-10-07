package com.example.admin_employee.controller;

import com.example.admin_employee.dto.AuthRequest;
import com.example.admin_employee.dto.AuthResponse;
import com.example.admin_employee.dto.RegisterRequest;
import com.example.admin_employee.model.Employee;
import com.example.admin_employee.repository.EmployeeRepository;
import com.example.admin_employee.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(EmployeeRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // ✅ Register (with new fields)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        // Check if email already exists
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new ResponseStatusException(CONFLICT, "Email already registered");
        }

        // Optional confirm password validation
        if (request.getConfirmPassword() != null && !request.getConfirmPassword().isEmpty()) {
            if (!request.getPassword().equals(request.getConfirmPassword())) {
                throw new ResponseStatusException(BAD_REQUEST, "Passwords do not match");
            }
        }

        // Create new employee
        Employee employee = new Employee();
        employee.setFullName(request.getFullName());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setEmail(request.getEmail());
        employee.setPassword(passwordEncoder.encode(request.getPassword()));
        employee.setBranch(request.getBranch());

        try {
            employee.setRole(Employee.Role.valueOf(request.getRole().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid role: must be ADMIN, USER, or EMPLOYEE");
        }

        repository.save(employee);

        // Auto-login: Generate JWT token
        UserDetails userDetails = User.builder()
                .username(employee.getEmail())
                .password(employee.getPassword())
                .roles(employee.getRole().name())
                .build();

        String token = jwtService.generateToken(userDetails);

        AuthResponse response = new AuthResponse(token, employee.getRole().name(), employee.getId());
        return ResponseEntity.status(CREATED).body(response);
    }

    // ✅ Login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Employee employee = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(UNAUTHORIZED, "Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), employee.getPassword())) {
            throw new ResponseStatusException(UNAUTHORIZED, "Invalid email or password");
        }

        // Create Spring UserDetails for token generation
        UserDetails userDetails = User.builder()
                .username(employee.getEmail())
                .password(employee.getPassword())
                .roles(employee.getRole().name())
                .build();

        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(
                new AuthResponse(token, employee.getRole().name(), employee.getId())
        );
    }
}
