package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.AuditDto;
import com.grantserve.grantserve1.entity.Audit;
import com.grantserve.grantserve1.enums.AuditStatus;
import com.grantserve.grantserve1.exception.AuditException;

import java.util.List;
import java.util.Optional;

public interface IAuditService {
    String createAudit(AuditDto auditDto) throws AuditException;
    String deleteAudit(int id) throws AuditException;
    Optional<Audit> getAudit(int id);
    List<Audit> getAuditByStatus(AuditStatus status);

    // New methods to match Controller
    List<Audit> getAllAudits();
    String updateAuditStatus(int id, AuditStatus status) throws AuditException;
}