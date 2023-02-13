package com.beyonder.companyemployee1tomservice.service;

import com.beyonder.companyemployee1tomservice.model.Company;
import com.beyonder.companyemployee1tomservice.model.Employee;
import com.beyonder.companyemployee1tomservice.repository.CompanyRepository;
import com.beyonder.companyemployee1tomservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final EmployeeRepository employeeRepository;

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Employee addEmployeeToCompany(Long companyId, Employee employee) {
        Company company = companyRepository.findById(companyId).get();
        employee.setCompany(company);
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByCompany(Long companyId) {
        return employeeRepository.findByCompany_Id(companyId);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}