package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.ResearcherDocumentDto;
import com.grantserve.grantserve1.entity.ResearcherDocument;
import com.grantserve.grantserve1.exception.ResearcherDocumentException;

import java.util.List;
import java.util.Optional;

public interface IResearcherDocumentService {
    String uploadDocument(ResearcherDocumentDto documentDto) throws ResearcherDocumentException;
    Optional<ResearcherDocument> getDocument(Long id);
    List<ResearcherDocument> getAllDocuments();

    // Updated signature
    String deleteDocument(Long researcherId, Long documentId) throws ResearcherDocumentException;
}

