package com.grantserve.grantserve1.repository;

import com.grantserve.grantserve1.entity.ComplianceRecord;
import com.grantserve.grantserve1.enums.ComplianceResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplianceRecordRepository extends JpaRepository<ComplianceRecord, Long> {
    List<ComplianceRecord> findByResult(ComplianceResult result);
}
