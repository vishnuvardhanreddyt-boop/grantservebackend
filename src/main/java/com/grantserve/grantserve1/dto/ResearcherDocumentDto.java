package com.grantserve.grantserve1.dto;

import com.grantserve.grantserve1.enums.DocType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResearcherDocumentDto(
        @NotNull(message = "Researcher ID is required")
        Long researcherID,

        @NotNull(message = "Document type is required")
        DocType docType,

        @NotBlank(message = "File URI is required")
        String fileURI
) {}
