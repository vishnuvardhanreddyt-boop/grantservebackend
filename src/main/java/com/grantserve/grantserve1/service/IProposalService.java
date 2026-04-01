package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.ProposalDto;
import com.grantserve.grantserve1.entity.Program;
import com.grantserve.grantserve1.exception.ProposalException;
import com.grantserve.grantserve1.projection.IProposalProjection;

import java.time.LocalDateTime;
import java.util.List;

public interface IProposalService {
    public String createProposal(ProposalDto proposal) throws ProposalException;

    List<IProposalProjection> getProposal(Long id);


}

