package com.example.admin_employee.repository;


import com.example.admin_employee.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;


public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
List<Attendance> findByEmployeeId(Long employeeId);
List<Attendance> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}


