package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.GrantApplicationDto;
import com.grantserve.grantserve1.entity.GrantApplication;
import com.grantserve.grantserve1.exception.GrantApplicationException;

import java.util.List;
import java.util.Optional;

public interface IGrantApplicationService {

    String createApplication(GrantApplicationDto grantApplication);

    String DeleteApplication(Long id);

    public GrantApplication getApplication(Long id) throws GrantApplicationException;

    public List<GrantApplication> search(Long id, String title);

    List<GrantApplication> FetchGrantApplication(Long id);

    Optional<List<GrantApplication>> fetchProgramGrantApplications(Long programID) throws GrantApplicationException;
}
