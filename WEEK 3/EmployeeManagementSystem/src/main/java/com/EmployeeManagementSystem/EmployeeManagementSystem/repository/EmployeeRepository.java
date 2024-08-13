package com.EmployeeManagementSystem.EmployeeManagementSystem.repository;

import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Using named queries defined in the Employee entity
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);

    List<Employee> findByNameContaining(@Param("name") String name);
}
