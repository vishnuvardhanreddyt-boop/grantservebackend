package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.GrantApplicationDto;
import com.grantserve.grantserve1.entity.Program;
import com.grantserve.grantserve1.entity.Researcher;
import com.grantserve.grantserve1.exception.ProposalException;
import com.grantserve.grantserve1.exception.ResearcherException;
import com.grantserve.grantserve1.repository.IGrantApplicationRepository;
import com.grantserve.grantserve1.entity.GrantApplication;
import com.grantserve.grantserve1.exception.GrantApplicationException;
import com.grantserve.grantserve1.repository.ProgramRepository;
import com.grantserve.grantserve1.repository.ResearcherRepository;
import com.grantserve.grantserve1.specification.GrantApplicationSpecification;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.grantserve.grantserve1.specification.GrantApplicationSpecification.hasName;

@Service
public class GrantApplicationServiceImpl implements IGrantApplicationService {

    @Autowired
    IGrantApplicationRepository grantApplicationDao;

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    ResearcherRepository researcherRepository;

    public String createApplication(GrantApplicationDto grantApplicationDto) throws GrantApplicationException {
        GrantApplication grantApplication = new GrantApplication();
        BeanUtils.copyProperties(grantApplicationDto,grantApplication);
        grantApplication.setStatus("Active");
        grantApplication.setSubmittedDate(LocalDate.now());

        Program program = programRepository.findById(grantApplicationDto.programID())
                .orElseThrow(() -> new ProposalException("Program Not found", HttpStatus.NOT_FOUND));
        grantApplication.setProgram(program);

        Researcher researcher = researcherRepository.findById(grantApplicationDto.researcherID())
                .orElseThrow(()->new ResearcherException("Researcher Not found",HttpStatus.NOT_FOUND));
        grantApplication.setResearcher(researcher);

        grantApplicationDao.save(grantApplication);
        return "Created SuccessFully";

    }

    public String DeleteApplication(Long id) throws  GrantApplicationException{
        if (!grantApplicationDao.existsById(id)) {
            throw new GrantApplicationException("Delete failed: No application found with ID " + id,HttpStatus.NOT_FOUND);
        }
        grantApplicationDao.deleteById(id);
        return "Deleted SuccessFully";
    }

    public GrantApplication getApplication(Long id) throws GrantApplicationException {
        return grantApplicationDao.findById(id)
                .orElseThrow(() -> new GrantApplicationException("Application not found for ID: " + id,HttpStatus.NOT_FOUND));
    }

    public List<GrantApplication> search(Long id, String name) {
        return grantApplicationDao.findAll(
                Specification.where(GrantApplicationSpecification.hasId(id))
                        .or(GrantApplicationSpecification.hasName(name))
        );
    }

    @Override
    public List<GrantApplication> FetchGrantApplication(Long id) throws GrantApplicationException {
        return grantApplicationDao.findByResearcher_ResearcherID(id)
                .orElseThrow(()->new GrantApplicationException("No Grant Applications found for the user "+id,HttpStatus.NOT_FOUND));
    }

    @Override
    public Optional<List<GrantApplication>> fetchProgramGrantApplications(Long programID) throws GrantApplicationException{
        return grantApplicationDao.findByProgram_ProgramID(programID);
    }


}
