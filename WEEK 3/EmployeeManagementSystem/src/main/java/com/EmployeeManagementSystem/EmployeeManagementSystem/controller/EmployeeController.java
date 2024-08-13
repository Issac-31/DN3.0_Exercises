package com.EmployeeManagementSystem.EmployeeManagementSystem.controller;

import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get paginated and sorted employees
    @GetMapping("/search")
    public Page<Employee> getPaginatedAndSortedEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        return employeeService.getPaginatedAndSortedEmployees(page, size, sortBy);
    }
}
