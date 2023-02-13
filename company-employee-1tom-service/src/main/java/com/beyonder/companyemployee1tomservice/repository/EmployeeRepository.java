package com.beyonder.companyemployee1tomservice.repository;

import com.beyonder.companyemployee1tomservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByCompany_Id(Long departmentId);
}
