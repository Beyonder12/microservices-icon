package com.beyonder.departmentservice.service;

import com.beyonder.departmentservice.entity.Department;
import com.beyonder.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Class : DepartmentService, method : saveDepartment...");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Class : DepartmentService, method : findDepartmentById...");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Department> getAll() {
        log.info("Class : DepartmentService, method : getAll...");
        return departmentRepository.findAll();
    }
}
