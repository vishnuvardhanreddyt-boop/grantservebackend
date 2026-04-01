package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.ResearcherDto;
import com.grantserve.grantserve1.entity.Researcher;
import com.grantserve.grantserve1.exception.ResearcherException;
import com.grantserve.grantserve1.projection.IResearcherProjection;

import java.util.List;
import java.util.Optional;

public interface IResearcherService {
    String UpdateResearcher(Long id,ResearcherDto researcherDto) throws ResearcherException;
    IResearcherProjection fetchResearcher(Long id) throws ResearcherException;
    String deleteResearcher(Long id) throws ResearcherException;

    Optional<Researcher> getResearcher(Long id);

}
