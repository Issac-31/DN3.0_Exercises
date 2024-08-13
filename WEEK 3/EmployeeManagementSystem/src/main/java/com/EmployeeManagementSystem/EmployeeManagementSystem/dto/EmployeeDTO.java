package com.EmployeeManagementSystem.EmployeeManagementSystem.dto;

public class EmployeeDTO {

    private String name;
    private String email;

    // Constructor
    public EmployeeDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
