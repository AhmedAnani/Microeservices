package com.example.Loans.config;

import jakarta.persistence.MappedSuperclass;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@MappedSuperclass
@EnableJpaAuditing(auditorAwareRef = "auditorAware")  // Enable auditing here
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> {
            // Get current user from security context or request
            // For now, return SYSTEM as default
            return Optional.of("SYSTEM");
        };
    }

}
