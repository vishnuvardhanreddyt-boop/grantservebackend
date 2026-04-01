package com.grantserve.grantserve1.repository;

import com.grantserve.grantserve1.entity.Audit;
import com.grantserve.grantserve1.enums.AuditStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditRepository extends JpaRepository<Audit, Long> {
    List<Audit> findByStatus(AuditStatus status);
}
