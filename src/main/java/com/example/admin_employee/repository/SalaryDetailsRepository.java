package com.example.admin_employee.repository;

import com.example.admin_employee.model.SalaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaryDetailsRepository extends JpaRepository<SalaryDetails, Long> {
    Optional<SalaryDetails> findByEmployeeId(Long employeeId);
}
