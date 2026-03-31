package com.grantserve.grantserve1.exception;

import org.springframework.http.HttpStatus;

public class ResearcherException extends RuntimeException {
    public ResearcherException(String message, HttpStatus notFound) {
        super(message);
    }
}
