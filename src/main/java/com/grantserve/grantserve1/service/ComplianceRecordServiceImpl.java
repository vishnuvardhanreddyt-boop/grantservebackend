package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.ComplianceRecordDto;
import com.grantserve.grantserve1.repository.ComplianceRecordRepository;
import com.grantserve.grantserve1.entity.ComplianceRecord;
import com.grantserve.grantserve1.enums.ComplianceResult;
import com.grantserve.grantserve1.exception.ComplianceRecordException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplianceRecordServiceImpl implements IComplianceRecordService{
    @Autowired
    ComplianceRecordRepository complianceRecordRepository;

    @Override
    public String createComplianceRecord(ComplianceRecordDto complianceRecordDto) throws ComplianceRecordException {
        ComplianceRecord complianceRecord = new ComplianceRecord();
        BeanUtils.copyProperties(complianceRecordDto, complianceRecord);
        complianceRecordRepository.save(complianceRecord);
        return "Created SuccessFully";
    }

    @Override
    public String deleteComplianceRecord(int id) throws  ComplianceRecordException{
        complianceRecordRepository.deleteById((long) id);
        return "Deleted SuccessFully";
    }

    @Override
    public Optional<ComplianceRecord> getComplianceRecord(int id) {
        return complianceRecordRepository.findById((long) id);
    }

    @Override
    public List<ComplianceRecord> getComplianceRecordByResult(ComplianceResult result) {
        return complianceRecordRepository.findByResult(result);
    }

}
