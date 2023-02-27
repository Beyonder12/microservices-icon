package com.beyonder.departmentservice.controller;

import com.beyonder.departmentservice.entity.Department;
import com.beyonder.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/test")
    public String test(){
        log.info("Class: DepartmentController, method: test...");
        return "Hello";
    }

    @GetMapping
    public List<Department> getAll(){
        log.info("Class: DepartmentController, method: getAll...");
        return departmentService.getAll();
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Class: DepartmentController, method: saveDepartment...");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{departmentId}")
    public Department findDepartmentById(@PathVariable("departmentId") Long departmentId) {
        log.info("Class: DepartmentController, method: findDepartmentById...");
        return departmentService.findDepartmentById(departmentId);
    }

}
