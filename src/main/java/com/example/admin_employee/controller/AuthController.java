                                                                                                                                                                                                             package com.example.admin_employee.controller;

import com.example.admin_employee.dto.AuthResponse;
import com.example.admin_employee.dto.LoginRequest;
import com.example.admin_employee.model.Employee;
import com.example.admin_employee.repository.EmployeeRepository;
import com.example.admin_employee.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class AuthController {

    private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(EmployeeRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // ✅ Login endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        // 🔹 Find employee by email
        Employee employee = repository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(UNAUTHORIZED, "Invalid email or password"));

        // 🔹 Validate password
        if (!passwordEncoder.matches(password, employee.getPassword())) {
            throw new ResponseStatusException(UNAUTHORIZED, "Invalid email or password");
        }

        // 🔹 Generate JWT token
        String token = jwtService.generateToken(employee);

        // 🔹 Return structured response
        AuthResponse response = new AuthResponse(token, employee.getRole().name(), employee.getId());
        return ResponseEntity.ok(response);
    }

    // ✅ Register endpoint
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        if (repository.findByEmail(email).isPresent()) {
            throw new ResponseStatusException(CONFLICT, "Email already exists");
        }

        Employee employee = new Employee();
        employee.setEmail(email);
//        employee.setUsername(email); // optional: set username same as email
        employee.setPassword(passwordEncoder.encode(password));
        employee.setRole(Employee.Role.USER); // default role

        repository.save(employee);

        String token = jwtService.generateToken(employee);
        AuthResponse response = new AuthResponse(token, employee.getRole().name(), employee.getId());
        return ResponseEntity.status(CREATED).body(response);
    }
}