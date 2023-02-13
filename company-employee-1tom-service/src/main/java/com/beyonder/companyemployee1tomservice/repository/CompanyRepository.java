package com.beyonder.companyemployee1tomservice.repository;

import com.beyonder.companyemployee1tomservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}