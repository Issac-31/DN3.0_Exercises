package com.EmployeeManagementSystem.EmployeeManagementSystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameEmailProjection {
    
    @Value("#{target.name + ' (' + target.email + ')'}")
    String getNameAndEmail();
}
