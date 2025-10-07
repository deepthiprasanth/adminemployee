//package com.example.admin_employee.controller;
//
//import com.example.admin_employee.model.Employee;
//import com.example.admin_employee.service.EmployeeService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/admin")
//public class EmployeeController {
//
//    private final EmployeeService employeeService;
//
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    // ✅ Register employee with nested details
//    @PostMapping("/employees")
//    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {
//        Employee saved = employeeService.saveEmployee(employee);
//        return ResponseEntity.ok(saved);
//    }
//
//    // ✅ Get all employees
//    @GetMapping("/employees")
//    public ResponseEntity<?> getAllEmployees() {
//        return ResponseEntity.ok(employeeService.getAllEmployees());
//    }
//
//    // ✅ Get employee by ID
//    @GetMapping("/employees/{id}")
//    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
//        return ResponseEntity.ok(employeeService.getEmployeeById(id));
//    }
//
//    // ✅ Delete employee
//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.ok().build();
//    }
//}
