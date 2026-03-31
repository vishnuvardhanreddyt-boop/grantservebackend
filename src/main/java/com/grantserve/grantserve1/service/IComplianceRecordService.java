package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.ComplianceRecordDto;
import com.grantserve.grantserve1.entity.ComplianceRecord;
import com.grantserve.grantserve1.enums.ComplianceResult;
import com.grantserve.grantserve1.exception.ComplianceRecordException;

import java.util.List;
import java.util.Optional;

public interface IComplianceRecordService {

    String createComplianceRecord(ComplianceRecordDto complianceRecordDto) throws ComplianceRecordException;

    String deleteComplianceRecord(int id) throws ComplianceRecordException;

    Optional<ComplianceRecord> getComplianceRecord(int id);

    List<ComplianceRecord> getComplianceRecordByResult(ComplianceResult result);
}
