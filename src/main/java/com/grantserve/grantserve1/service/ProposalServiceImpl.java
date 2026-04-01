package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.ProposalDto;
import com.grantserve.grantserve1.repository.IGrantApplicationRepository;
import com.grantserve.grantserve1.repository.IProposalRepository;
import com.grantserve.grantserve1.entity.GrantApplication;
import com.grantserve.grantserve1.entity.Proposal;
import com.grantserve.grantserve1.exception.ProposalException;
import com.grantserve.grantserve1.projection.IProposalProjection;
import com.grantserve.grantserve1.util.ClassUtilSeparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalServiceImpl implements  IProposalService {
    @Autowired
    IProposalRepository proposalDao;
    @Autowired
    IGrantApplicationRepository grantApplicationRepository;


    public String createProposal(ProposalDto proposalDto) throws ProposalException {
        Proposal proposal = ClassUtilSeparator.proposalUtil(proposalDto);

        GrantApplication application = grantApplicationRepository.findById(proposalDto.applicationID())
                .orElseThrow(() -> new ProposalException("Application Not found",HttpStatus.NOT_FOUND));
        proposal.setGrantApplication(application);

        proposalDao.save(proposal);
        return "Created SuccessFully";
    }

    public List<IProposalProjection> getProposal(Long id){
        return proposalDao.findProjectedById(id);
    }
}
