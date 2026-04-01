package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.ProgramDto;
import com.grantserve.grantserve1.entity.Program;
import com.grantserve.grantserve1.projection.IProgramProjection;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProgramService {

    @Transactional
    ProgramDto createProgram(ProgramDto programDto);

    @Transactional
    String updateProgram(ProgramDto programDto);

    @Transactional
    String updateProgramStatusToClosed(Long id);

    Optional<IProgramProjection> getProgram(Long id);

    List<IProgramProjection> getAllPrograms();

    List<IProgramProjection> getActiveApplications(LocalDate now);

    List<IProgramProjection> searchProgram(String title, Long id, boolean isManager);
}