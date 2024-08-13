package com.EmployeeManagementSystem.EmployeeManagementSystem.repository;

import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Find departments by name using JPQL
    @Query("SELECT d FROM Department d WHERE d.name = :name")
    Department findDepartmentByName(String name);

    // Find all departments with more than a certain number of employees
    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) > :count")
    List<Department> findDepartmentsWithMoreThanXEmployees(int count);

    // Find all departments using a native SQL query
    @Query(value = "SELECT * FROM department WHERE name LIKE %:name%", nativeQuery = true)
    List<Department> findDepartmentsByNameNative(String name);
}
