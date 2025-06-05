package com.pm.patient_service.exception;

public class EmailAlreadyExistsExcepion extends RuntimeException {
    public EmailAlreadyExistsExcepion(String message) {
        super(message);
    }
}
