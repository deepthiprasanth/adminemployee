//package com.example.admin_employee.controller;
//
//import com.example.admin_employee.model.Attendance;
//
//import com.example.admin_employee.model.Employee;
//import com.example.admin_employee.repository.EmployeeRepository;
//import com.example.admin_employee.security.JwtService;
//import com.example.admin_employee.service.AttendanceService;
//import com.example.admin_employee.service.LeaveService;
//import com.example.admin_employee.util.LocationUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//
//@RestController
//@RequestMapping("/api/attendance")
//public class AttendanceController {
//
//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private AttendanceService attendanceService;
//
//    @Autowired
//    private LeaveService leaveService;
//
//    @Autowired
//    private Environment env;
//
//    /**
//     * Mark attendance with location validation and ON_DUTY leave check
//     */
//    @PostMapping("/mark")
//    public ResponseEntity<?> markAttendance(
//            @RequestHeader("Authorization") String token,
//            @RequestParam double latitude,
//            @RequestParam double longitude
//    ) {
//        try {
//            // Extract username from JWT
//            String jwt = token.substring(7); // remove "Bearer "
//            String username = jwtService.extractUsername(jwt);
//
//            Employee employee = employeeRepository.findByUsername(username)
//                    .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//            // Office location from application.properties
//            double officeLat = Double.parseDouble(env.getProperty("office.latitude"));
//            double officeLon = Double.parseDouble(env.getProperty("office.longitude"));
//            double radius = Double.parseDouble(env.getProperty("office.radius", "100")); // default 100m
//
//            // Calculate distance
//            double distance = LocationUtil.distance(latitude, longitude, officeLat, officeLon);
//            boolean withinOffice = distance <= radius;
//
//            // Check ON_DUTY leave
//            boolean onDuty = leaveService.isOnDuty(employee.getId(), LocalDate.now());
//
//            if (!withinOffice && !onDuty) {
//                return ResponseEntity.badRequest().body("Outside office location and not on duty.");
//            }
//
//            // Mark attendance with all parameters
//            Attendance attendance = attendanceService.markAttendance(
//                    employee.getId(),
//                    true,           // present
//                    onDuty,         // onDuty
//                    latitude,
//                    longitude,
//                    null            // note
//            );
//
//            return ResponseEntity.ok(attendance);
//
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error marking attendance: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Get all attendance records for logged-in employee
//     */
//    @GetMapping("/employee")
//    public ResponseEntity<?> getAttendance(@RequestHeader("Authorization") String token) {
//        try {
//            String jwt = token.substring(7);
//            String username = jwtService.extractUsername(jwt);
//            Employee employee = employeeRepository.findByUsername(username)
//                    .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//            return ResponseEntity.ok(attendanceService.getByEmployee(employee.getId()));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error fetching attendance: " + e.getMessage());
//        }
//    }
//}
