package com.example.admin_employee.repository;

import com.example.admin_employee.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmployeeId(Long employeeId);

    List<LeaveRequest> findByStatus(String status);

    @Query("SELECT l FROM LeaveRequest l WHERE l.employee.id = :employeeId " +
           "AND :date BETWEEN l.startDate AND l.endDate")
    List<LeaveRequest> findByEmployeeIdAndDate(Long employeeId, LocalDate date);
}
