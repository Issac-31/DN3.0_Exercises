package com.EmployeeManagementSystem.EmployeeManagementSystem.repository;

import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Using @Value annotation in Projection
    List<EmployeeNameEmailProjection> findByDepartmentId(Long departmentId);
}
