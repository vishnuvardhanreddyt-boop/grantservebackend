package com.grantserve.grantserve1.projection;

import java.time.LocalDateTime;
public interface IProposalProjection {
    Long getProposalID();
    String getFileURI();
    LocalDateTime getSubmittedDate();
    String getStatus();
    Long getApplicationID();
}
