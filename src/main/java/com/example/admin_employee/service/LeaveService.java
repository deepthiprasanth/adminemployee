package com.example.admin_employee.service;

import com.example.admin_employee.model.Employee;
import com.example.admin_employee.model.LeaveRequest;
import com.example.admin_employee.repository.EmployeeRepository;
import com.example.admin_employee.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveRequestRepository leaveRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    /**
     * Apply for a new leave
     */
    public LeaveRequest applyLeave(Long employeeId, String leaveType, LocalDate startDate, LocalDate endDate) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        LeaveRequest leave = new LeaveRequest();
        leave.setEmployee(employee);
        leave.setLeaveType(leaveType);
        leave.setStartDate(startDate);
        leave.setEndDate(endDate);
        leave.setStatus("PENDING");

        return leaveRepo.save(leave);
    }

    /**
     * Approve a leave
     */
    public LeaveRequest approveLeave(Long leaveId) {
        LeaveRequest leave = leaveRepo.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setStatus("APPROVED");
        return leaveRepo.save(leave);
    }

    /**
     * Reject a leave
     */
    public LeaveRequest rejectLeave(Long leaveId) {
        LeaveRequest leave = leaveRepo.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setStatus("REJECTED");
        return leaveRepo.save(leave);
    }

    /**
     * Withdraw a leave request (only if it has not started yet)
     */
    public void withdrawLeave(Long leaveId) {
        LeaveRequest leave = leaveRepo.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        if (leave.getStartDate().isAfter(LocalDate.now())) {
            leave.setStatus("WITHDRAWN");
            leaveRepo.save(leave);
        } else {
            throw new RuntimeException("Leave already started, cannot withdraw.");
        }
    }

    /**
     * Check if employee has an ON_DUTY leave on given date
     */
    public boolean isOnDuty(Long employeeId, LocalDate date) {
        return leaveRepo.findByEmployeeIdAndDate(employeeId, date)
                .stream()
                .anyMatch(l -> l.getLeaveType().equalsIgnoreCase("ON_DUTY")
                        && l.getStatus().equalsIgnoreCase("APPROVED"));
    }

}
