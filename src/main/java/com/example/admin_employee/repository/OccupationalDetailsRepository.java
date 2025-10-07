package com.example.admin_employee.repository;

import com.example.admin_employee.model.OccupationalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OccupationalDetailsRepository extends JpaRepository<OccupationalDetails, Long> {
    Optional<OccupationalDetails> findByEmployeeId(Long employeeId);
}
