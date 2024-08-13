package com.EmployeeManagementSystem.EmployeeManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Entity
@Data
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByDepartmentId",
        query = "SELECT e FROM Employee e WHERE e.department.id = :departmentId"
    ),
    @NamedQuery(
        name = "Employee.findByNameContaining",
        query = "SELECT e FROM Employee e WHERE e.name LIKE %:name%"
    )
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}
