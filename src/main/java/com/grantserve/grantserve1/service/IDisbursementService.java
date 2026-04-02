package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.DisbursementDto;
import com.grantserve.grantserve1.entity.Disbursement;
import java.util.List;

public interface IDisbursementService {
    Disbursement initiateDisbursement(DisbursementDto dto);
    void reconcileBudget(Long programId, Double amount);
    List<Disbursement> trackByApplication(Long appId);
    List<Disbursement> trackByStatus(String status);
    void deleteDisbursement(Long id);
}