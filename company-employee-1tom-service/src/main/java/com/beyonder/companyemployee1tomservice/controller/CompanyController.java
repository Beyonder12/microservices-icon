package com.beyonder.companyemployee1tomservice.controller;

import com.beyonder.companyemployee1tomservice.model.Company;
import com.beyonder.companyemployee1tomservice.model.Employee;
import com.beyonder.companyemployee1tomservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @PostMapping("/{companyId}/employees")
    public Employee addEmployeeToCompany(@PathVariable Long companyId, @RequestBody Employee employee) {
        return companyService.addEmployeeToCompany(companyId, employee);
    }

    @GetMapping("/{companyId}/employees")
    public List<Employee> getEmployeesByCompany(@PathVariable Long companyId) {
        return companyService.getEmployeesByCompany(companyId);
    }
}