package com.example.Loans.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditlog {

    // WHEN created
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // WHO created
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    // WHEN updated
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // WHO updated
    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;
}
