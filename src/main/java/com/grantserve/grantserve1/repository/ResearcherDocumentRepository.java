package com.grantserve.grantserve1.repository;
import com.grantserve.grantserve1.entity.ResearcherDocument;
import com.grantserve.grantserve1.projection.IResearcherProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResearcherDocumentRepository extends JpaRepository<ResearcherDocument, Long> {
    Optional<ResearcherDocument> findByDocumentIDAndResearcher_ResearcherID(Long documentID, Long researcherID);

    List<ResearcherDocument> findByResearcher_ResearcherID(Long researcherID);

    List<ResearcherDocument> findByVerificationStatus(String status);
}

