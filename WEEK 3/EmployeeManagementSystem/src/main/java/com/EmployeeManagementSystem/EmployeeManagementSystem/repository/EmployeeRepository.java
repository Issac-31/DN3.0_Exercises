package com.EmployeeManagementSystem.EmployeeManagementSystem.repository;

import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query methods
    List<Employee> findByDepartmentId(Long departmentId);
    
    List<Employee> findByNameContaining(String name);
}
