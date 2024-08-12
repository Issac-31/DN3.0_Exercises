package com.EmployeeManagementSystem.EmployeeManagementSystem.repository;

import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    // Derived query methods
    Department findByName(String name);
}
