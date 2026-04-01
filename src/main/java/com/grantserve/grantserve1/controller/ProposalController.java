package com.grantserve.grantserve1.controller;

import com.grantserve.grantserve1.dto.ProposalDto;
import com.grantserve.grantserve1.projection.IProposalProjection;
import com.grantserve.grantserve1.service.IProposalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @Autowired
    IProposalService proposalService;

    @PostMapping("/createProposal")
    public ResponseEntity<String> createProposal(@Valid @RequestBody ProposalDto proposal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proposalService.createProposal(proposal));
    }

    @GetMapping("/getProposal/{proposalId}")
    public ResponseEntity<List<IProposalProjection>> getProposal(@PathVariable Long proposalId){
        return ResponseEntity.status(200).body(proposalService.getProposal(proposalId));

    }
}
