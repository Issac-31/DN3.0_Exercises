package com.EmployeeManagementSystem.EmployeeManagementSystem.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Here, you can return the currently logged-in user. 
        // For now, returning a static user for simplicity.
        return Optional.of("System");
    }
}
