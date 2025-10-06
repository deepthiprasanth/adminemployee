package com.example.admin_employee.service;


import com.example.admin_employee.model.Attendance;
import com.example.admin_employee.model.Employee;
import com.example.admin_employee.repository.AttendanceRepository;
import com.example.admin_employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class AttendanceService {
private final AttendanceRepository attendanceRepository;
private final EmployeeRepository employeeRepository;


public AttendanceService(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository) {
this.attendanceRepository = attendanceRepository;
this.employeeRepository = employeeRepository;
}


public Attendance markAttendance(Long employeeId, boolean present, boolean onDuty, double lat, double lon, String note) {
Optional<Employee> empOpt = employeeRepository.findById(employeeId);
if (empOpt.isEmpty()) throw new RuntimeException("Employee not found");
Employee emp = empOpt.get();


Attendance a = new Attendance();
a.setEmployee(emp);
a.setTimestamp(LocalDateTime.now());
a.setPresent(present);
a.setOnDuty(onDuty);
a.setLatitude(lat);
a.setLongitude(lon);
a.setNote(note);


return attendanceRepository.save(a);
}


public List<Attendance> getByEmployee(Long employeeId) { return attendanceRepository.findByEmployeeId(employeeId); }
}