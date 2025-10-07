package com.example.admin_employee.repository;

import com.example.admin_employee.model.ProfessionalDetails;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalDetailsRepository extends JpaRepository<ProfessionalDetails, Long> {
	Optional<ProfessionalDetails> findByEmployeeId(Long employeeId);
}
