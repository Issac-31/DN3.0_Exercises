package com.EmployeeManagementSystem.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Creating a new department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Getting all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Getting a department by ID
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Updating an existing department
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Deleting a department by ID
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
