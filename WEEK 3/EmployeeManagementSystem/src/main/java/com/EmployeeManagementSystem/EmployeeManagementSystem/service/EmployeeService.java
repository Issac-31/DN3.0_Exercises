package com.EmployeeManagementSystem.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Fetch paginated and sorted employee list
    public Page<Employee> getPaginatedAndSortedEmployees(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }
}
