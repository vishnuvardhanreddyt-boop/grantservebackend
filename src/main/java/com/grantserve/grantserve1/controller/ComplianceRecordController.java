package com.grantserve.grantserve1.controller;

import com.grantserve.grantserve1.dto.ComplianceRecordDto;
import com.grantserve.grantserve1.entity.ComplianceRecord;
import com.grantserve.grantserve1.enums.ComplianceResult;
import com.grantserve.grantserve1.service.ComplianceRecordServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Locale;

@RestController
@RequestMapping("/GrantServe")
public class ComplianceRecordController {
    @Autowired
    ComplianceRecordServiceImpl complianceRecordService;
    @PostMapping("/createComplianceRecord")
    public ResponseEntity<String> createComplianceRecord(@Valid @RequestBody ComplianceRecordDto complianceRecord){
        return ResponseEntity.status(HttpStatus.CREATED).body(complianceRecordService.createComplianceRecord(complianceRecord));
    }
    @DeleteMapping("/DeleteComplianceRecord/{id}")
    public ResponseEntity<String> DeleteComplianceRecord(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(complianceRecordService.deleteComplianceRecord(id));

    }
    @GetMapping("getComplianceRecord/{id}")
    public ResponseEntity<ComplianceRecord> getComplianceRecord(@PathVariable int id) {
        return complianceRecordService.getComplianceRecord(id)
                .map(app -> ResponseEntity.ok(app))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("getComplianceRecordByResult/{result}")
    public ResponseEntity<?> getComplianceRecordByResult(@PathVariable ComplianceResult result) {
        ComplianceResult enumValue = toComplianceResult(String.valueOf(result));
        return ResponseEntity.ok(complianceRecordService.getComplianceRecordByResult(enumValue));
    }

    private ComplianceResult toComplianceResult(String value) {
        try {
            return ComplianceResult.valueOf(value.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid result. Allowed values: " + Arrays.toString(ComplianceResult.values())
            );
        }
    }

}